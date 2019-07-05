package day2;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Game1 extends JFrame {

    //初始化窗口
    public void launchFrame() {
        this.setTitle("菜鸟程序员");
        this.setVisible(true);
        this.setSize(500,500);
        this.setLocation(300,300);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        Game1 f = new Game1();
        f.launchFrame();
    }
}
