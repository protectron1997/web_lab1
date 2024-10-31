package controller;

import share.Coordinates;
import share.ValidateX;

import java.util.Objects;



public class NewParser {
    private ValidateX validateX;
    



    public Coordinates parse(String data){
        Coordinates result = new Coordinates();
        int counter = 0; //будет считать кол-во обработанных значений
        StringBuilder badParseInfo = new StringBuilder();

        for(String chunk : data.split("&")) {

            String[] keyValue = chunk.split("=");

            if (Objects.equals(keyValue[0], "x")) {


                try {
                    double x = Double.parseDouble(keyValue[1]);
                }
                catch (NumberFormatException e){
                    badParseInfo.append("x isn't double ");
                }
                if (x >= -5 && x <= 3) {
                    this.x = x;
                } else {
                    badParseFlag = true;
                    badParseInfo.append("false x ");
                }
            }

            if (Objects.equals(keyValue[0], "y")) {
                try {
                    y = Integer.parseInt(keyValue[1]);
                }
                catch (NumberFormatException e){
                    badParseInfo.append("y isn't int ");
                }

                if (y >= -4 && y <= 4) {
                    this.y = y;
                } else {
                    badParseFlag = true;
                    badParseInfo.append("false y ");
                }
            }

            if (Objects.equals(keyValue[0], "r")) {
                try {
                    r = Double.parseDouble(keyValue[1]);
                }
                catch (NumberFormatException e){
                    badParseInfo.append("r isn't double ");
                }
                if (r >= 2 && r <= 5) {
                    this.r = r;
                } else {
                    badParseFlag = true;
                    badParseInfo.append("false r ");
                }
            }


        }


        return result;
    }
}
