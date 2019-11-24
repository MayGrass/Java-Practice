/*
* 101213050
* 許冬清
*/
// 用javac -encoding UTF-8編譯
import java.util.*;
public class StringReverse {
    public static String reverse(String source, int n) {
        int num = (int)(source.length()/n); //字串長度除以n，判斷要分幾組陣列
        int check = source.length()%n; //算是否整除
        if (check != 0) //如果有餘數，要多一組陣列存剩下的字串
            num++;
        String[] group = new String[num]; //創陣列存分出來的字串
        int k = 0;
        for (int i = 0; i < source.length(); i+=n) { //分組存字串，一組n個
            if (i+n >= source.length()) { //如果最後一組了，就把剩下的存起來，不然陣列會爆
                group[k] = source.substring(i);
            }
            else {
                group[k] = source.substring(i,i+n); //依據輸入的 n，對字串做分群，
                k++; //存完換下一組
            }
        }
        StringBuffer temp[] = new StringBuffer[num]; //暫存用陣列
        StringBuffer result = new StringBuffer(); //存反轉字串用的StringBuffer
        for (int i = 0; i < num; i++) {
            temp[i] = new StringBuffer(); //初始化StringBuffer陣列，不然會發生NullPointerException
            temp[i].append(group[i]); //用暫存陣列把之前存的分組附加出來
            result.append(temp[i].reverse()); //反轉後再附加給結果
        }
        return result.toString(); //回傳轉換成String的result
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        System.out.print(reverse(input.next(), input.nextInt()));//輸入字串與幾個字串分一組
    }
}