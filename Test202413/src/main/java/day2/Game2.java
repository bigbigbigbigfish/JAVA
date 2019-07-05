package day2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Game2 extends JFrame {

    Image   ball  = GameUtil.getImage("E:\\JAVA\\Test202413\\src");

    @Override
    public void paint(Graphics g) {		//自动调用,
        Color   c = g.getColor();
        Font   f =  g.getFont();
        g.setColor(Color.BLUE);

        g.drawLine(100, 100, 300, 300);
        g.drawRect(100, 100, 300, 300);
        g.drawOval(100, 100, 300, 300);
        g.fillRect(100, 100, 40, 40);
        g.setColor(Color.red);
        g.setFont(new  Font("宋体",Font.BOLD,50));
        g.drawString("我是谁?", 200, 200);

        g.drawImage(ball, 250, 250, null);

        g.setColor(c);
        g.setFont(f);



    }

    public  void  launchFrame(){
        this.setTitle("菜鸟程序员");
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocation(300, 300);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        Game1  f = new Game1();
        f.launchFrame();
    }

}
