public class RegularOctagon extends Shape2D {
    private double height;
    public String name;
    public String getName() {
        return name;
    }
    public RegularOctagon(String n, double h) {
        name = n;
        height = h;
    }
    public double area() {
        return (2+2*Math.sqrt(2))*Math.pow(height,2);
    }
}