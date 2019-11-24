import javax.swing.*;
import java.lang.*;
import java.awt.event.*;
import java.awt.*;

class Queue {
    int[] data = new int[10];
    int head, tail, size;
    public void add(int x) {
        data[tail++] = x;
        tail %= data.length; //環狀返回的位置
        size++;
    }  
    public void remove() {
        data[head++] = -1;
        head %= data.length;
        size--;
    }
    public boolean isFull() { //當陣列儲滿10個資料時就滿了
        return size == 10;
    }    
}

public class GUI_Queue extends JFrame implements ActionListener {
    JLabel[] label = new JLabel[10];
    JTextField input;
    Queue q = new Queue();
    //set Label
    public void CreateJLabel() {
        for (int i = 0; i < 10; i++) {
            q.data[i] = -1; //讓Queue data 初始值為 -1
            label[i] = new JLabel("空", JLabel.CENTER);
            label[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
            this.add(label[i]); 
        }
    }
    //設定輸入後所執行的動作，如果是remove則刪除Queue，其他則加入Queue
    //參數 e 就是 ActionEvent 物件，接著呼叫 ActionEvent 的 getActionCommand()
    public void actionPerformed(ActionEvent e) {
        String token = e.getActionCommand();
        if(token.equals("取用")) {
            if(q.data[q.head] == -1) 
                JOptionPane.showMessageDialog(null, "現在是空值唷");
            else
                q.remove();
        } else {
            try {
                //如果輸入的整數是大於零的
                if (Integer.parseInt(token) >= 0) {
                    //判斷現在Queue裡面是不是滿了
                    if(!q.isFull())
                        //沒有滿就新增該正整數
                        q.add(Integer.parseInt(token));
                    else
                        //滿了就提示他滿了
                        JOptionPane.showMessageDialog(null, "現在是滿的呦");
                }
                else
                    //不是大於零的整數就提示他
                    JOptionPane.showMessageDialog(null, "嗚嗚 請輸入正整數 QAQ");
            } catch(Exception err){
                JOptionPane.showMessageDialog(null, "輸入錯誤惹");
            }
        }
        SetJLabelResult();
        input.setText("");
    }
    
    //把 Queue 內容設定到Label
    public void SetJLabelResult() {
        for (int i = 0; i < 10; i++)
            if(q.data[i] == -1) {
                label[i].setText("空");
            } else {
                label[i].setText(Integer.toString(q.data[i]));
            }
    }
    
    public GUI_Queue() {
        //set layout size
        this.setSize(800,300);
        this.setLayout(new GridLayout(1, 12)); //row, collume
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set Labels
        CreateJLabel();
        //set text input field
        input = new JTextField();
        input.addActionListener(this);
        this.add(input);
        //set remove button
        JButton remove = new JButton("取用");
        remove.addActionListener(this);
        this.add(remove);
        this.setVisible(true);
    }
    
    public static void main(String[] argv) {
        new GUI_Queue();
    }
}