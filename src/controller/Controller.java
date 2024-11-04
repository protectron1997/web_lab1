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
            Coordinates coordinates;
            String content;
            String data = FCGIInterface.request.params.getProperty("QUERY_STRING");
            

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
