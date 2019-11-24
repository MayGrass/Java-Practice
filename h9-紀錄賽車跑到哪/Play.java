/*
* 101213050
* 許冬清
*/
// 用javac -encoding UTF-8編譯
import java.util.*;
import java.math.*;
class Car {
    private String name;
    private int pointX = 0;
    private int pointY = 0;
    public Car(String name) {
        //設定車子名字
        this.name = name;
    }
    public int[] getPoints() {
        //取得點Ｘ及點Ｙ位置
        int[] n = new int[2];
        n[0] = pointX;
        n[1] = pointY;
        return n;
    }
    public void setPoints(int X, int Y) {
        pointX = X;
        pointY = Y;
        //設定點Ｘ及點Ｙ位置
    }
    public String getName() {
        //回傳車子名子
        return name;
    }
    public void go(int X, int Y) {
        //車子移動到 X , Y
        if (X >= 10 || Y >= 10 || X < 0 || Y < 0) //賽地(10 * 10方格)
            System.out.println("超出棋盤範圍");
        else { //移動步數需用絕對值顯示
            if (Y < pointY)
                System.out.println("向上走 走"+Math.abs(Y-pointY)+"步");
            else
                System.out.println("向下走 走"+Math.abs(pointY-Y)+"步");
            if (X < pointX)
                System.out.println("向左走 走"+Math.abs(X-pointX)+"步");
            else
                System.out.println("向右走 走"+Math.abs(pointX-X)+"步");
            setPoints(X,Y);
        }
    }
}
public class Play {
    public static void main (String[] argv) {
        //主程式
        System.out.print("輸入車名：");
        Scanner input = new Scanner(System.in);
        Car bus = new Car(input.next());
        while(true) { //無限迴圈直到輸入結束的指令
            System.out.print("請輸入指令:");
            String command = input.next();
            switch(command) { //依照輸入指令做事，不是設定的指令就會重來
                case "go": 
                    bus.go(input.nextInt(), input.nextInt());
                    break;
                case "list":
                    System.out.print(bus.getName());
                    System.out.println(" 在 ("+bus.getPoints()[0]+","+bus.getPoints()[1]+")");
                    break;
                case "end":
                    System.out.print("離開.....%");
                    return;
                default:
                    System.out.println("指令無效，請重新輸入");
            }
        }
    }
}