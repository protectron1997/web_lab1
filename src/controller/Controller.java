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
        Parser mainParser = new Parser();


        while (fcgiInterface.FCGIaccept() >= 0) {
            Coordinates coordinates = null;
            String content = "";
            String data = FCGIInterface.request.params.getProperty("QUERY_STRING");
            

            try{
                coordinates = mainParser.extractValues(data);
                content = mainModel.generate(coordinates);
                View.send(content);
            }
            catch (ParseException e){
                View.send(JSON.genStandardJSON("error", e.getMessage(), String.valueOf(0)));
            }








            /*content = mainModel.generate(data);
            view.View.send(content);*/

        }
    }



}
