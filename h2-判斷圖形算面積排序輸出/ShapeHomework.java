/*
* 101213050
* 許冬清
*/
// 用javac -encoding UTF-8編譯
import java.util.*;
import java.math.*;
public class ShapeHomework {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        System.out.print("輸入\nn=");
        int n = input.nextInt();
        String type;
        String name[] = new String[n];
        double num1;
        double num2;
        double num3;
        double area[] = new double[n];
        double all_sum = 0;
        for (int i = 0; i < n; i++) {
            type = input.next();
            name[i] = input.next();
            switch(type) { //判斷輸入的圖形然後根據公式算面積
                case "Circle": //Circle
                    num1 = input.nextDouble();
                    area[i] = (double)(Math.PI*Math.pow(num1,2));
                    break;
                
                case "Rectangle": //Rectangle
                    num1 = input.nextDouble();
                    num2 = input.nextDouble();
                    area[i] = (double)(num1*num2);
                    break;
                
                case "Square": //Square
                    num1 = input.nextDouble();
                    area[i] = (double)(Math.pow(num1,2));
                    break;
                
                case "Triangle": //Triangle
                    num1 = input.nextDouble();
                    num2 = input.nextDouble();
                    area[i] = (double)((num1*num2)/2);
                    break;
            
                case "RegularOctagon": //RegularOctagon
                    num1 = input.nextDouble();
                    area[i] = (double)((2+2*Math.sqrt(2))*Math.pow(num1,2));
                    break;
            
                case "Trapezoid": //Trapezoid
                    num1 = input.nextDouble();
                    num2 = input.nextDouble();
                    num3 = input.nextDouble();
                    area[i] = (double)((num1+num2)*num3/2);
                    break;
                    
                default: //必須符合規定的圖形種類否則就終止程式
                    System.out.print("請輸入符合的圖形類別!");
                    return;
            }
            all_sum += area[i];//算總和面積
        }
        for(int i = n-1; i > 0; i--) { // 升冪排列
            for(int k = 0; k < i; k++) {
                if (area[k] > area[k+1]) { //遞增遞減判斷
                    String temp_name = name[k];
                    name[k] = name[k+1];
                    name[k+1] = temp_name;
                    double temp_area = area[k];
                    area[k] = area[k+1];
                    area[k+1] = temp_area;
                }
            }
        }
        System.out.println("輸出");
        for (int i = 0; i < n; i++)
            System.out.println(""+name[i]+" "+area[i]);            
        System.out.print("\n"+all_sum);
    }
}    