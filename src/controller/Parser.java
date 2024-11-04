package controller;

import Exceptions.ParseException;
import Exceptions.ValidateException;
import share.Coordinates;
import share.ValidateR;
import share.ValidateX;
import share.ValidateY;

import java.util.Objects;



public class Parser {
    private final ValidateX validateX = new ValidateX();
    private final ValidateY validateY = new ValidateY();
    private final ValidateR validateR = new ValidateR();
    



    public Coordinates parse(String data) throws ParseException {
        Coordinates result = new Coordinates();
        int counter = 0; //будет считать кол-во обработанных значений
        StringBuilder badParseInfo = new StringBuilder();

        for(String chunk : data.split("&")) {

            String[] keyValue = chunk.split("=");

            if (Objects.equals(keyValue[0], "x")) {
                try {
                    double x = Double.parseDouble(keyValue[1]);
                    if(validateX.check(x)){
                        result.setX(x);
                        counter++;
                    }
                }
                catch (NumberFormatException e){
                    badParseInfo.append("x isn't double ");
                }
                catch (ValidateException e){
                    badParseInfo.append(e.getMessage());
                }

            }

            if (Objects.equals(keyValue[0], "y")) {
                try {
                    int y = Integer.parseInt(keyValue[1]);
                    if (validateY.check(y)) {
                        result.setY(y);
                        counter++;
                    }
                } catch (NumberFormatException e) {
                    badParseInfo.append("y isn't int ");
                } catch (ValidateException e) {
                    badParseInfo.append(e.getMessage());
                }
            }

            if (Objects.equals(keyValue[0], "r")) {
                try {
                    double r = Double.parseDouble(keyValue[1]);
                    if(validateR.check(r)){
                        result.setR(r);
                        counter++;
                    }
                }
                catch (NumberFormatException e){
                    badParseInfo.append("r isn't double ");
                }
                catch (ValidateException e){
                    badParseInfo.append(e.getMessage());
                }
            }


        }

        if(!(badParseInfo.toString().equals(""))){
            throw new ParseException(badParseInfo.toString());
        }

        if((counter != 3) || (Double.isNaN(result.getX()) || (Double.isNaN(result.getR()) || (result.getY() == null) ))){
            throw new ParseException("wrong number of arguments(xyr) or check that(xyr) exists ");
        }

        return result;
    }
}
