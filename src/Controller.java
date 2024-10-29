import com.fastcgi.FCGIInterface;

public class Controller {
    private final FCGIInterface fcgiInterface;

    Controller(FCGIInterface fcgiInterface){
        this.fcgiInterface = fcgiInterface;
    }

    void run(){
        Model mainModel = new Model();
        Parser mainParser = new Parser();

        while (fcgiInterface.FCGIaccept() >= 0) {

            String data = FCGIInterface.request.params.getProperty("QUERY_STRING");



            String content = mainModel.generate(data);
            View.send(content);

        }
    }



}
