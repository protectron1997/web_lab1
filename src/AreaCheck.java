public class AreaCheck {
    public static boolean hit(int x, int y, int r){
        return kvadrat(x,y,r) || krug(x,y,r) || triangle(x,y,r);
    }

    public static boolean kvadrat(int x, int y, int r){
        return ((x >= -r) && (x <= 0) && (y <= r) && (y >= 0));
    }

    public static boolean krug (int x, int y, int r){
        double length = Math.sqrt(x*x + y*y);
        return ((x>=0) && (y<=0) && (length <= ((double) r /2)));
    }

    public static boolean triangle (int x, int y, int r){
        int i = -2*x - (r / 2) - y;
        return ((x<=0) && (y<=0) && (y>=-r) && (x >= (r/2)) && (0 >= i));
    }
}
