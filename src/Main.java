import com.fastcgi.FCGIInterface;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        var fcgiInterface = new FCGIInterface();
        Controller mainController = new Controller(fcgiInterface);
        mainController.run();


    }
}