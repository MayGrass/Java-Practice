import java.lang.*;
public class PenFractalLine {
    public static Pen p = new Pen();
    public static void fractalLine(int x, int y, double h, double r) {
        if(h <= 1) {
            p.flyTo(x,y);
            p.runTo(x,y);
            return;
        }
        //劃出4個小fractalLine
        //第1段,起點(x,y),長度h/3,角度r
        fractalLine(x, y, h/3.0, r);
        //第2段,起點(x,y)+h/3*(cos(r),sin(r)),長度h/3,角度r+60
        int nextX = x + (int)(h/3.0*Math.cos(Math.toRadians(r)));
        int nextY = y + (int)(h/3.0*Math.sin(Math.toRadians(r)));
        fractalLine(nextX, nextY, h/3, r-60);
        //第3段,起點....,長度h/3, 角度r-60
        nextX = nextX + (int)(h/3.0*Math.cos(Math.toRadians(r-60)));
        nextY = nextY + (int)(h/3.0*Math.sin(Math.toRadians(r-60)));
        fractalLine(nextX, nextY, h/3, r+60);
        //第4段,起點....,長度h/3, 角度r
        nextX = x + (int)(h/3.0*2*Math.cos(Math.toRadians(r)));
        nextY = y + (int)(h/3.0*2*Math.sin(Math.toRadians(r)));
        fractalLine(nextX, nextY, h/3, r);
    }
    public static void main(String[] argv) {
        fractalLine(50,300,2700,0);
    }
}