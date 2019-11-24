/*
* 101213050
* 許冬清
*/
// 用javac -encoding UTF-8編譯
import java.util.*;
public class Fibonacci {
    public static long fnum(long n) {
        // 請使用遞迴完成尋找費氏數列
        if (n <= 1) return n;
        else return fnum(n-1) + fnum(n-2);
    }


    public static long sum(long n) {
        // 加總函式
        long sum = 0;
        for (int i = 1; i <= n; i++)
            sum += fnum(i);
        return sum;
    }


    public static void main(String[] argv) {
        // 主程式
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入你要找的數：");
        long n = input.nextInt();
        System.out.println("第 "+n+" 個數為："+fnum(n));
        System.out.println("總共的值："+sum(n));
    }
}