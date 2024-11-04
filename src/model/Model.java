package model;

import share.Coordinates;
import share.JSON;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Model {


    public String generate(Coordinates coordinates){
        double x = coordinates.getX();
        int y = coordinates.getY();
        double r = coordinates.getR();
        var content = "";


        try {

            var start = Instant.now();
            content = String.valueOf(AreaCheck.hit(x, y, r));
            var end = Instant.now();

            long time = ChronoUnit.NANOS.between(start,end);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
            content = JSON.genStandardJSON(content, String.valueOf(time), LocalDateTime.now().format(dtf));
        }
        catch (Exception e){
            String error = e.getMessage();
            error = error.replace("\"", " ");
            content = JSON.genStandardJSON("error",error, "0");
        }



        return content;
    }


}

