public class Circle extends Shape2D{
    private double radius;
    private static fina double PI = 3.141592654;
    public Circle(double r){
        radius = r;
    }
    public double area(){
        return PI * radius * radius;
    }
}    