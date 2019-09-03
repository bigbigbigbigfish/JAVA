package com.cao.client.service;

import com.cao.util.CommUtils;
import com.cao.vo.MessageVO;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class PrivateChatGUI {
    private JPanel privateChatGUI;
    private JTextArea readFromServer;
    private JTextField sendServer;
    private JFrame frame;
    private String myName;
    private String friendName;
    private ConnectToServer connectToServer;

    private PrintStream out;


    public PrivateChatGUI(String friendName,String myName,ConnectToServer connectToServer) {
        this.friendName = friendName;
        this.myName = myName;
        this.connectToServer = connectToServer;
        try {
            this.out = new PrintStream(connectToServer.getOut(),true,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("与" + " 私聊中");
        frame.setContentPane(privateChatGUI);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
        //捕捉输入框的键盘输入
        sendServer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                StringBuilder sb = new StringBuilder();
                sb.append(sendServer.getText());
                //当捕捉到 按下Enter
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    //将当前信息发送到服务端
                    String msg = sb.toString();
                    MessageVO messageVO = new MessageVO();
                    messageVO.setType("2");
                    messageVO.setContent(myName+"_"+msg);
                    messageVO.setTo(friendName);
                    PrivateChatGUI.this.out.println(CommUtils.objectToJson(messageVO));
                    readFromServer(myName+":"+"说" + msg);
                    sendServer.setText(null);
                }
                //将自己发送的信息展示到私聊界面
            }
        });
    }

    public void readFromServer(String msg) {
        readFromServer.append(msg+"\n");
    }

    public JFrame getFrame() {
        return frame;
    }
}
