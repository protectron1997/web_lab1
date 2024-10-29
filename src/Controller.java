import com.fastcgi.FCGIInterface;

public class Controller {
    private final FCGIInterface fcgiInterface;

    Controller(FCGIInterface fcgiInterface){
        this.fcgiInterface = fcgiInterface;
    }

    void run(){
        ContentGen generator = new ContentGen();

        while (fcgiInterface.FCGIaccept() >= 0) {

            String data = FCGIInterface.request.params.getProperty("QUERY_STRING");
            String content = generator.generate(data);
            View.send(content);

        }
    }



}
