interface ShapeInterface{
    public static final double PI = 3.1415926536;
    public abstract double area();
}
interface SubShape extends ShapeInterface{
    
}
interface Strange{
    int varl = 10;
    void fun();
}
interface Multi extends SubShape,Strange{
    double PI = 3.0;
    void fun();
}
interface Second{
    
}
public class TestInterface implements Multi,Second{
    public void fun(){
        System.out.println("TestInterface use print to implements")
    }
    public double area(){
        return Multi.PI;
    }
    public static void main(String )
}