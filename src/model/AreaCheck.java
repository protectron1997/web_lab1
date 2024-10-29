package model;

public class AreaCheck {
    public static boolean hit(double x, int y, double r){
        return kvadrat(x,y,r) || krug(x,y,r) || triangle(x,y,r);
    }

    public static boolean kvadrat(double x, int y, double r){
        return ((x >= -r) && (x <= 0) && (y <= r) && (y >= 0));
    }

    public static boolean krug (double x, int y, double r){
        double length = Math.sqrt(x*x + y*y);
        return ((x>=0) && (y<=0) && (length <= ((double) r /2)));
    }

    public static boolean triangle (double x, int y, double r){
        double i = -2*x - (r / 2) - y;
        return ((x<=0) && (y<=0) && (y>=-r) && (x >= (r/2)) && (0 >= i));
    }
}
