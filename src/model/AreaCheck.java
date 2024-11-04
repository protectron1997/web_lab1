package model;

public class AreaCheck {
    public static boolean hit(double x, int y, double r){
        return square(x,y,r) || circle(x,y,r) || triangle(x,y,r);
    }

    public static boolean square(double x, int y, double r){
        return ((x >= -r) && (x <= 0) && (y <= r) && (y >= 0));
    }

    public static boolean circle(double x, int y, double r){
        double length = Math.sqrt(x*x + y*y);
        return ((x>=0) && (y<=0) && (length <= (r /2)));
    }

    public static boolean triangle (double x, int y, double r){
        double i = -2*x - (r / 2) - y;
        return ((x<=0) && (y<=0) && (y>=-r) && (x >= (r/2)) && (0 >= i));
    }
}
