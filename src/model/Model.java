package model;

import share.Coordinates;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Model {
    private double x,r;
    private int y;

    String JSON = """
            {
            "result": "%s",
            "time_exec": "%s",
            "date": "%s"
            }
            """;



    public String generate(Coordinates coordinates){
        this.x = coordinates.getX();
        this.y = coordinates.getY();
        this.r = coordinates.getR();
        var content = "";

        if(true){
            try {
                /*extractValues(data);*/
                var start = Instant.now();
                content = String.valueOf(AreaCheck.hit(this.x,this.y,this.r));
                var end = Instant.now();

                long time = ChronoUnit.NANOS.between(start,end);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
                content = JSON.formatted(String.valueOf(AreaCheck.hit(this.x,this.y,this.r)),time,LocalDateTime.now().format(dtf));
            }
            catch (Exception e){
                String error = e.getMessage();
                error = error.replace("\"", " ");
                //content = JSON.formatted("error",'0','0');
                content = JSON.formatted("error",error,'0');
            }


        }
        return content;
    }


    public String generate(String data){
        int y = 0;
        double x=0, r=0;
        var content = "";

        if(data != null){
            try {
                extractValues(data);
                var start = Instant.now();
                content = String.valueOf(AreaCheck.hit(this.x,this.y,this.r));
                var end = Instant.now();

                long time = ChronoUnit.NANOS.between(start,end);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
                content = JSON.formatted(String.valueOf(AreaCheck.hit(this.x,this.y,this.r)),time,LocalDateTime.now().format(dtf));
            }
            catch (Exception e){
                String error = e.getMessage();
                error = error.replace("\"", " ");
                //content = JSON.formatted("error",'0','0');
                content = JSON.formatted("error",error,'0');
            }


        }
        return content;
    }

    private void generateJSON(double x, int y, double r){

    }

    private void extractValues(String data) throws Exception {

        for(String chunk : data.split("&")) {
            String[] keyValue = chunk.split("=");
            if (Objects.equals(keyValue[0], "x")) {
                x = Double.parseDouble(keyValue[1]);
                if (x >= -5 && x <= 3) {
                    this.x = x;
                } else {
                    throw new Exception("false x");
                }
            }
            if (Objects.equals(keyValue[0], "y")) {
                y = Integer.parseInt(keyValue[1]);
                if (y >= -4 && y <= 4) {
                    this.y = y;
                } else {
                    throw new Exception("false y");
                }
            }
            if (Objects.equals(keyValue[0], "r")) {
                r = Double.parseDouble(keyValue[1]);
                if (r >= 2 && r <= 5) {
                    this.r = r;
                } else {
                    throw new Exception("false r");
                }
            }
        }

        }
    }

