package controller;


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
            Coordinates coordinatesOfDot;
            String contentToSend;
            String dataFromUser = FCGIInterface.request.params.getProperty("QUERY_STRING");
            

            try{
                coordinatesOfDot = MainParser.parse(dataFromUser);
                contentToSend = mainModel.generate(coordinatesOfDot);
                View.send(contentToSend);
            }
            catch (Exception e){
                View.errorSend(JSON.genStandardJSON("error", e.getMessage(), String.valueOf(0)));
            }
        }
    }



}
