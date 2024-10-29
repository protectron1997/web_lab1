import Exceptions.ParseException;

import java.util.HashMap;
import java.util.Objects;




public class Parser{
    private double x,r;
    private int y;



    public HashMap<String, String> parse (String data) throws ParseException {
        double x,r;
        int y;
        boolean badFlag = false;
        StringBuilder badMessage = new StringBuilder();
        HashMap<String, String> extValues = new HashMap<>();


        for(String chunk : data.split("&")) {

            String[] keyValue = chunk.split("=");

            if (Objects.equals(keyValue[0], "x")) {
                x = Double.parseDouble(keyValue[1]);
                if (x >= -5 && x <= 3) {
                    this.x = x;
                } else {
                    badFlag = true;
                    badMessage.append("false x");
                }
            }
            if (Objects.equals(keyValue[0], "y")) {
                y = Integer.parseInt(keyValue[1]);
                if (y >= -4 && y <= 4) {
                    this.y = y;
                } else {
                    badFlag = true;
                    badMessage.append("false y");
                }
            }
            if (Objects.equals(keyValue[0], "r")) {
                r = Double.parseDouble(keyValue[1]);
                if (r >= 2 && r <= 5) {
                    this.r = r;
                } else {
                    badFlag = true;
                    badMessage.append("false r");
                }
            }
            if (badFlag){
                throw new ParseException(badMessage.toString());
            }
            else{
                extValues.put("x", String.valueOf(this.x));
                extValues.put("y", String.valueOf(this.x));
                extValues.put("r", String.valueOf(this.x));
                return extValues;
            }


    }
        return extValues;
    }
}
