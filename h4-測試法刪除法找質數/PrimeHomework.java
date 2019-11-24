/*
* 101213050
* 許冬清
*/
// 用javac -encoding UTF-8編譯
import java.util.*;
public class PrimeHomework {
    public static boolean isPrimes(int n) {
        for(int i=2; i*i<=n; i++)
            if (n%i==0)
                return false;
            return true;
    }
    public static int primes(long n) { //測試法
        int counter = 0;
        for(int i=2;i<=n;i++)
            if(isPrimes(i))
                counter++;
        return counter;
    }
    public static int p2(long n) { //刪除法 
        boolean[] notPrime = new boolean[(int)(n+1)];  
        //boolean預設是false        
        for(int i=2; i<=n; i++) {
            if(!notPrime[i]) {
                for(int j=i; i*j<=n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        // 篩選合數
        int counter = 1;
        for (int i=3; i<=n; i++) {
            if(!notPrime[i])
                counter++;
        }
        // 計算質數個數
        return counter;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        long StartTime1 = System.currentTimeMillis(); //測試法開始時間
        System.out.print("測試法 "+primes(n)+"個 ");
        long ProcessTime1 = System.currentTimeMillis() - StartTime1; //測試法計算時間
        System.out.println(+ProcessTime1+"ms");
        long ST2 = System.currentTimeMillis(); //刪除法開始時間
        System.out.print("刪除法 "+p2(n)+"個 ");
        long PT2 = System.currentTimeMillis() - ST2; //刪除法計算時間
        System.out.println(+PT2+"ms");
    }
}