/*
* 101213050
* 許冬清
*/
// 用javac -encoding UTF-8編譯
import java.util.*;
import java.lang.*;
public class FractalPolygon {
    public static Pen p = new Pen();
    public static void fractalLine(int x, int y, double h, double r) {
        if(h <= 1) {
            p.flyTo(x,y);
            p.runTo(x,y);
            return;
        }
        //劃出4個小fractalLine
        fractalLine(x, y, h/3, r);
        //第1段 起點,長度都是h/3,角度r
        int nextX = x + (int)(h/3.0*Math.cos(Math.toRadians(r)));
        int nextY = y + (int)(h/3.0*Math.sin(Math.toRadians(r)));
        fractalLine(nextX, nextY, h/3, r-60);
        //第2段 角度+60
        nextX += (int)(h/3.0*Math.cos(Math.toRadians(r-60)));
        nextY += (int)(h/3.0*Math.sin(Math.toRadians(r-60)));
        fractalLine(nextX, nextY, h/3, r+60);
        //第3段 角度-60
        nextX = x + (int)(h/3.0*2*Math.cos(Math.toRadians(r)));
        nextY = y + (int)(h/3.0*2*Math.sin(Math.toRadians(r)));
        fractalLine(nextX, nextY, h/3, r);
        //第4段 
    }
    //老余上課版
    public static void fractalpolygon(int x,int y, double h,int n) {
        double angle = 360/n; //等邊角
        double side_length = 2*h*Math.sin(Math.toRadians(angle/2)); //邊長
        for (int i=0; i<n; i++) {
            int nextX = (int)(x+h*Math.cos(Math.toRadians(i*angle-90)));
            int nextY = (int)(y+h*Math.sin(Math.toRadians(i*angle-90)));
            fractalLine(nextX,nextY,side_length,(i+0.5)*angle);
        }
    }
    public static void main(String[] argv) {
        fractalpolygon(400,300,280,3);
    }
}