import java.util.*;
import java.util.regex.*;
public class RunLengthEncoding {
 
    public static String encode(String source) { //編碼
        StringBuffer code = new StringBuffer(); //StringBuffer為可以變動的String
        for (int i = 0; i < source.length(); i++) {
            int runLength = 1;
            while (i+1 < source.length() && source.charAt(i) == source.charAt(i+1)) { //第一個條件是防止字串後面沒字 自爆
                runLength++;
                i++;
            }
            code.append(source.charAt(i)); //append為新增字串
            code.append(runLength);
        }
        return code.toString();
    }
 
    public static String decode(String source) { //解碼 
        StringBuffer code = new StringBuffer();
        for (int i = 0; i < source.length(); i += 2) { //每兩位就會是數字
            int number = source.charAt(i+1) - 48; //他就是要-48才會是輸入的數字
            while (number-- != 0)
                code.append(source.charAt(i));
        }
        return code.toString();
    }
 
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        while(true) { //無限回圈
            String n = input.next();
            Pattern pattern = Pattern.compile("[1-9]"); //符合出現數字1~9
            Matcher matcher = pattern.matcher(n);
            if(matcher.find()) //有出現數字就是要解碼
                System.out.println(decode(n));
            else if(n.startsWith("end")) //輸入end結束程式
                break;            
            else
                System.out.println(encode(n)); //不然就是要編碼啦
            /*int isNum = n.charAt(1) - 48;        
            if (isNum > 0 && isNum < 10)
                System.out.println(decode(n));
            else if (n.startsWith("end"))
                break;
            else if (isNum > 9)
                System.out.println(encode(n));*/
        }
    }
}