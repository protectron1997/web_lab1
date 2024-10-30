package controller;

import Exceptions.ParseException;
import share.Coordinates;

import java.util.Objects;




public class Parser{
    private double x,r;
    private int y;



    public Coordinates extractValues(String data) throws ParseException {
        boolean badParseFlag = false;
        StringBuilder badParseInfo = new StringBuilder();
        Coordinates coordinates = new Coordinates();

        for(String chunk : data.split("&")) {

            String[] keyValue = chunk.split("=");

            if (Objects.equals(keyValue[0], "x")) {

                x = Double.parseDouble(keyValue[1]);
                if (x >= -5 && x <= 3) {
                    this.x = x;
                } else {
                    badParseFlag = true;
                    badParseInfo.append("false x ");
                }
            }

            if (Objects.equals(keyValue[0], "y")) {
                y = Integer.parseInt(keyValue[1]);
                if (y >= -4 && y <= 4) {
                    this.y = y;
                } else {
                    badParseFlag = true;
                    badParseInfo.append("false y ");
                }
            }

            if (Objects.equals(keyValue[0], "r")) {

                r = Double.parseDouble(keyValue[1]);
                if (r >= 2 && r <= 5) {
                    this.r = r;
                } else {
                    badParseFlag = true;
                    badParseInfo.append("false r ");
                }
            }


        }

        if (badParseFlag){
            throw new ParseException(badParseInfo.toString());
        }

        coordinates.setX(this.x);
        coordinates.setY(this.y);
        coordinates.setR(this.r);


        return coordinates;
    }
}
