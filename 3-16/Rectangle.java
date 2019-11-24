public class Rectangle extends Shape2D{
    private double width,heigh;
    public Rectangle (double w,double h){
        width = w;
        heigh = h;
    }
    //override area () defined in Shape2D
    public double area(){
        return width * heigh;
    }
}