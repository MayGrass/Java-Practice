public class Trapezoid extends Shape2D {
    private double up, down, height;
    public String name;
    public String getName() {
        return name;
    }
    public Trapezoid(String n, double u, double d, double h) {
        name = n;
        up = u;
        down = d;
        height = h;
    }
    public double area() {
        return (up+down)*height/2;
    }
}