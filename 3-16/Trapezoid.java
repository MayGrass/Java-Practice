public class Trapezoid extends Shape2D{
    private double up,down,height;
    public Trapezoid(double u,d,h){
        up = u;
        down = d;
        height = h;
    }
    public double area(){
        return (uo + down) * height;
    }
}