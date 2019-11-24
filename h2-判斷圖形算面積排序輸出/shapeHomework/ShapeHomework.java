/*
* 101213050
* 許冬清
*/
// 用javac -encoding UTF-8編譯
// 圖形面積計算只有Circle.java有註解
import java.util.*;
public class ShapeHomework {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Shape2D[] x = new Shape2D[n]; //新增物件陣列Shape2D
        for (int i = 0; i < n; i++) {
            String type = input.next();
            switch(type) { //判斷輸入的圖形
                case "Circle": //Circle
                    x[i] = new Circle(input.next(),input.nextDouble());
                    break;
                
                case "Rectangle": //Rectangle
                    x[i] = new Rectangle(input.next(),input.nextDouble(),input.nextDouble());
                    break;
                
                case "Square": //Square
                    x[i] = new Square(input.next(),input.nextDouble());
                    break;
                
                case "Triangle": //Triangle
                    x[i] = new Triangle(input.next(),input.nextDouble(),input.nextDouble());
                    break;
            
                case "RegularOctagon": //RegularOctagon
                    x[i] = new RegularOctagon(input.next(),input.nextDouble());
                    break;
            
                case "Trapezoid": //Trapezoid
                    x[i] = new Trapezoid(input.next(),input.nextDouble(),input.nextDouble(),input.nextDouble());
                    break;
                    
                default: //必須符合規定的圖形種類否則就終止程式
                    System.out.print("請輸入符合的圖形類別!");
                    return;
            }
        }
        Sort(x); //排序
        for (int i = 0; i < n; i++) //輸出排序好的各圖形命名與面積
            System.out.println(x[i].getName()+" "+x[i].area());            
        System.out.print("\n"+SumShape.sum(x)); //輸出全部圖形面積總和
    }
    
    public static void Sort(Shape2D[] list) {
        for(int i = list.length-1; i > 0; i--) { // 升冪排列
            for(int k = 0; k < i; k++) {
                if (list[k].area() > list[k+1].area()) { //遞增遞減判斷
                    Shape2D temp = list[k+1];
                    list[k+1] = list[k];
                    list[k] = temp;
                }
            }
        }
    }
}