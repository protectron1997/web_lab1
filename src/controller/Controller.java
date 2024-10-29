package controller;

import com.fastcgi.FCGIInterface;
import model.Model;
import share.Coordinates;
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
            String data = FCGIInterface.request.params.getProperty("QUERY_STRING");
            

            try{
                coordinates = mainParser.extractValues(data);
                String content = mainModel.generate(coordinates);
                View.send(content);
            }
            catch (Exception e){
                View.send("HELLO");
            }

            /*String content = mainModel.generate(data);
            view.View.send(content);*/

        }
    }



}
