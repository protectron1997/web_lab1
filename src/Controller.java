import Exceptions.ParseException;
import com.fastcgi.FCGIInterface;

import java.util.HashMap;

public class Controller {
    private final FCGIInterface fcgiInterface;

    Controller(FCGIInterface fcgiInterface){
        this.fcgiInterface = fcgiInterface;
    }

    void run(){
        Model mainModel = new Model();
        Parser mainParser = new Parser();


        while (fcgiInterface.FCGIaccept() >= 0) {
            Coordinates coordinates = null;
            String data = FCGIInterface.request.params.getProperty("QUERY_STRING");

            /*try {
                exValues = mainParser.parse(data);
                String content = mainModel.generate(exValues);
                View.send(content);
            }
            catch (ParseException e){
                //System.out.println(e.getMessage());
            }*/

            try{
                coordinates = mainParser.extractValues(data);
                String content = mainModel.generate(coordinates);
                View.send(content);
            }
            catch (Exception e){
                View.send("HELLO");
            }

            /*String content = mainModel.generate(data);
            View.send(content);*/

        }
    }



}
