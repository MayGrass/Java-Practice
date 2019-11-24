/*
* 101213050
* 許冬清
*/
// 用javac -encoding UTF-8編譯
import java.util.*;
public class PrintFish {
    public static void main(String[] argv) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("n=");
        n = input.nextInt();
        System.out.println();
        int x=0; //上半部迴圈i從大開始但我需要小的變數所以設來用
        for (int i = n; i >= 1; i--) { //上半部N層
        //每層分四部分 以每層得出的規律來跑for的次數
            for (int j = 1; j <= 3*(i-1); j++)
                System.out.print(" ");
            for (int k = 1; k <= 3+(6*x); k++)
                System.out.print("*");
            for (int l = 1; l <= 4*(i-1); l++) 
                System.out.print(" ");
            for (int m = 1; m <= x; m++)
                System.out.print("*");
            x++;
            System.out.println("");
        }
        int y=n-2; //下半部迴圈用 跟上半部相反
        for (int i = 1; i <= n-1; i++) { //下半部N-1層
            for (int j = 1; j <= 3*i; j++)
                System.out.print(" ");
            for (int k = 1; k <= 3+(6*y); k++)
                System.out.print("*");
            for (int l = 1; l <= 4*i; l++)
                System.out.print(" ");
            for (int m = 1; m <= y; m++)
                System.out.print("*");
            y--;
            System.out.println("");
        }
    }
}    