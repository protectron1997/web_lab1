import java.util.HashMap;
import java.util.Objects;

public class Parser {
    public static HashMap<String, String> parse(String data) {

        double x,r;
        int y;
        HashMap<String, String> params = new HashMap<String, String>();
        for(String chunk : data.split("&")){
            String[] keyValue = chunk.split("=");
            if(Objects.equals(keyValue[0], "x")){
                x = Double.parseDouble(keyValue[1]);
            }
            if(Objects.equals(keyValue[0], "y")){
                y = Integer.parseInt(keyValue[1]);
            }
            if(Objects.equals(keyValue[0], "r")){
                r = Double.parseDouble(keyValue[1]);
            }
        }

        return params;
    }
}
