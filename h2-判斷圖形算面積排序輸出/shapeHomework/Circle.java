import java.math.*;
public class Circle extends Shape2D {
    private double radius; //半徑
    public String name;
    public String getName() {
        return name; //回傳自己命名的名字
    }
    public Circle(String n,double r) {
        //抓取自己輸入的名字和半徑
        name = n;
        radius = r;
    }
    public double area() {
        return Math.PI*Math.pow(radius,2); //根據公式計算面積後回傳
    }
}