public class Square extends Shape2D {
    private double height;
    public String name;
    public String getName() {
        return name;
    }
    public Square(String n, double h) {
        name = n;
        height = h;
    }
    public double area() {
        return Math.pow(height,2);
    }
}