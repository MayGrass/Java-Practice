import java.lang.*;
public class TestPen {
    public static Pen p = new Pen();
    public static void triangle(int x, int y, int h) {
        p.flyTo(x, y);
        p.runTo((int)(x+h/Math.sqrt(3)+0.5),y + h);
        p.runTo((int)(x-h/Math.sqrt(3)+0.5),y + h);
        p.runTo(x, y);
    }
    public static void fractalTriangle (int x, int y, int h ) {
        if (h <= 1) {
            p.flyTo(x, y);
            p.runTo(x, y);
            return;
        } // 遞迴程式要先寫邊際條件才能作遞迴呼叫

        fractalTriangle(x, y, h/2);
        fractalTriangle((int)(x+h/Math.sqrt(3)/2+0.5), y+h/2, h/2);
        fractalTriangle((int)(x-h/Math.sqrt(3)/2+0.5), y+h/2, h/2);
    }
    public static void fractalSquare(int x, int y, int h) {
        if (h <= 1) {
            p.flyTo(x, y);
            p.runTo(x, y);
            /*try {
                Thread.currentThread().sleep(1);
            } catch(Exception err) {
            }*/
            // 動畫慢慢畫
            return;
        }
        
        fractalSquare(x,y,h/3);
        fractalSquare(x+h/3, y, h/3);
        fractalSquare(x+h*2/3, y, h/3);
        fractalSquare(x, y+h/3, h/3);
        fractalSquare(x+h*2/3, y+h/3, h/3);
        fractalSquare(x,y+h*2/3,h/3);
        fractalSquare(x+h/3,y+h*2/3,h/3);
        fractalSquare(x+h*2/3,y+h*2/3,h/3);
        
    }
    public static void main(String[] argv) {
        fractalSquare(150, 50, 500);
    } 
} 