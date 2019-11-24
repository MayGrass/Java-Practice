public class Triangle extends Shape2D {
    private double base, height;
    public String name;
    public String getName() {
        return name;
    }
    public Triangle(String n, double b, double h) {
        name = n;
        base = b;
        height = h;
    }
    public double area() {
        return base*height/2;
    }
}