public class Rectangle extends Shape2D {
    private double width, length;
    public String name;
    public String getName() {
        return name;
    }
    public Rectangle(String n, double w, double l) {
        name = n;
        width = w;
        length = l;
    }
    public double area() {
        return width*length;
    }
}