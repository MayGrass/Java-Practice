/*
* 101213050
* 許冬清
*/
// 用javac -encoding UTF-8編譯
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GomokuHomework extends JFrame implements ActionListener {
    private Chess gomokuBoard;
    private GomokuHomework() {
        super("五子棋");
        Menu m;//
        MenuBar mb;
        gomokuBoard = new Chess(this);
        this.add(gomokuBoard);
        this.setMenuBar(mb = new MenuBar());
        mb.add(m = new Menu("遊戲")).add(new MenuItem("新遊戲")).addActionListener(this);
        mb.add(new Menu("說明")).add(new MenuItem("關於本遊戲")).addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    

        this.pack();
        this.setVisible(true);
    }
    public static void main(String argv[]) {
        new GomokuHomework();
    }
    // implements the ActionListener interface
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("關於本遊戲")) {
            JOptionPane.showMessageDialog(this, "棋子感應區符合人性了!", "遊戲說明", JOptionPane.INFORMATION_MESSAGE);
        } else if (command.equals("新遊戲")) {
            gomokuBoard.newGame();
        }
    }
}
class Chess extends Component implements MouseListener {
    public static final byte EMPTY = 0;//未下棋
    public static final byte BLACK = 1;//黑子
    public static final byte WHITE = 2;//白子
    private byte[][] board = new byte[19][19]; 
    private byte playing = BLACK; //黑子先手
    private Dimension mySize = new Dimension(565,565); //視窗大小
    private Frame parent;
    public Chess(Frame p) {
        this.addMouseListener(this);
        parent = p;
    }
    // The following 5 functions implement the MouseListener interface
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
        double check_row = (double)(e.getX()/10-1)/3;
        double check_col = (double)(e.getY()/10-1)/3; //座標簡化成0~18
        //System.out.println(check_row + "," + check_col); //測試座標值用
        //if (check_row != (int)check_row || check_col != (int)check_col) return; //座標簡化後必須是整數，不是的話就是沒下準，不給你下啦
        int row, col;
        // 下棋感應區為棋子四周各半格
        if (check_row - (int)check_row >= 0.5 )
            row = (int)check_row + 1; //強制轉換成整數
        else
            row = (int)check_row;
        if (check_col - (int)check_col >= 0.5 )
            col = (int)check_col + 1;
        else            
            col = (int)check_col;
        if (row < 0 || row > 18 || col < 0 || col > 18) return; //超過邊界不能下
        if (board[row][col] != EMPTY) return;
        if (board[row][col] == EMPTY) { //此位置可以下
            board[row][col] = playing;
            repaint(); // notify Window Manager
            //判定輸贏
            int Win_row = 0;
            for (int i = row; i < 19; i++) { //橫向往右找
                if (board[row][col] == board[i][col])
                    Win_row++;
                else break;
            }
            for (int i = row; i >= 0; i--) { //橫向往左找
                if (board[row][col] == board[i][col])
                    Win_row++;
                else break;
            }
            int Win_col = 0;
            for (int i = col; i < 19; i++) { //縱向往下找
                if (board[row][col] == board[row][i])
                    Win_col++;
                else break;
            }
            for (int i = col; i >= 0; i--) { //縱向往上找
                if (board[row][col] == board[row][i])
                    Win_col++;
                else break;
            }
            int Win_rightdown = 0;
            for (int i = row,j = col; i < 19 && j < 19; i++,j++) { //往右下
                if (board[row][col] == board[i][j])
                    Win_rightdown++;
                else break;
            }
            for (int i = row,j = col; i >= 0 && j >= 0; i--,j--) { //右下往回
                if (board[row][col] == board[i][j])
                    Win_rightdown++;
                else break;
            }
            int Win_leftdown = 0;
            for (int i = row,j = col; i >= 0 && j < 19; i--,j++) { //往左下
                if (board[row][col] == board[i][j])
                    Win_leftdown++;
                else break;
            }
            for (int i = row,j = col; i < 19 && j >= 0; i++,j--) { //左下往回
                if (board[row][col] == board[i][j])
                    Win_leftdown++;
                else break;
            }            
            if (Win_row > 5 || Win_col > 5 || Win_rightdown > 5 || Win_leftdown > 5) { //判定誰五連獲勝
                if (playing == BLACK) {
                    JOptionPane.showMessageDialog(this, "黑子獲勝!", "Win!", JOptionPane.INFORMATION_MESSAGE);
                } else if(playing == WHITE) {
                    JOptionPane.showMessageDialog(this, "白子獲勝!", "Win!", JOptionPane.INFORMATION_MESSAGE);
                }
                this.newGame();
                return;
            }
            if(playing == BLACK) {
                playing = BLACK;
            } else {
                playing = WHITE;
            }
            playing ^= 0x03; //黑白子交換下
        }
    }
    // override paint() defined in Component
    public void paint(Graphics g) {
        for (int i = 0; i < 19; i++) {
            g.drawLine(10, 10+30*i, 550, 10+30*i);//橫線
            g.drawLine(10+30*i, 10, 10+30*i, 550);//直線
        } //19*19棋盤
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] == BLACK) { //陣列被佔據就畫黑子
                    g.setColor(Color.black);
                    g.fillOval(i*30,15+j*30-15,20,20);
                } else if (board[i][j] == WHITE) { //畫白子
                    g.setColor(Color.white);
                    g.fillOval(i*30,15+j*30-15,20,20);
                }
            }
        }
    }
    public void newGame() { //清空陣列
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                board[i][j] = EMPTY;
            }
        }
        playing = BLACK;
        repaint();
    }
    // override getPreferredSize defined in Component,
    // so that the Component has proper size on screen
    public Dimension getPreferredSize() {
        return mySize;
    }
}