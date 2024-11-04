package controller;

import Exceptions.ParseException;
import com.fastcgi.FCGIInterface;
import model.Model;
import share.Coordinates;
import share.JSON;
import view.View;

public class Controller {
    private final FCGIInterface fcgiInterface;

    public Controller(FCGIInterface fcgiInterface){
        this.fcgiInterface = fcgiInterface;
    }

    public void run(){
        Model mainModel = new Model();
        Parser MainParser = new Parser();


        while (fcgiInterface.FCGIaccept() >= 0) {
            Coordinates coordinates = null;
            String content = "";
            String data = FCGIInterface.request.params.getProperty("QUERY_STRING");
            
            //777 если новых функций не будет - объедини catch
            try{
                coordinates = MainParser.parse(data);
                content = mainModel.generate(coordinates);
                View.send(content);
            }
            catch (ParseException e){
                View.errorSend(JSON.genStandardJSON("error", e.getMessage(), String.valueOf(0)));
            }
            catch (Exception e){
                View.errorSend(JSON.genStandardJSON("error", e.getMessage(), String.valueOf(0)));
            }
        }
    }



}
