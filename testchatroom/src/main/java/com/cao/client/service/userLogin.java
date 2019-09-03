package com.cao.client.service;

import com.cao.client.dao.AccountDao;
import com.cao.client.entiy.User;
import com.cao.util.CommUtils;
import com.cao.vo.MessageVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.Set;


public class userLogin {
    private JPanel userLogin;
    private JPanel userNamePanel;
    private JPanel userN;
    private JTextField userNameText;
    private JTextField passwordTextField;
    private JButton regButton;
    private JButton loginButton;
    private JPasswordField passwordField1;
    AccountDao accountDao = new AccountDao();

    public userLogin() {
        final JFrame frame = new JFrame("用户登录");
        frame.setContentPane(userLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        //注册按钮
        regButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出注册页面
                new UserReg();
            }
        });

        //登录按钮
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //去数据库检验用户信息
                String userName = userNameText.getText();
                String password = String.valueOf(passwordField1.getPassword());
                User user = accountDao.userLogin(userName,password);
                if(user != null){
                    //成功，加载用户列表

                    JOptionPane.showMessageDialog(frame,"登录成功！","提示信息",JOptionPane.INFORMATION_MESSAGE);
                    //与服务器建立连接，将当前用户名与密码发送到服务端
                    ConnectToServer connectToServer = new ConnectToServer();
                    MessageVO msgToSever = new MessageVO();
                    msgToSever.setType("1");
                    msgToSever.setContent(userName);
                    //json序列化
                    String jsonToSever = CommUtils.objectToJson(msgToSever);
                    try {
                        //将流给服务端
                        PrintStream out = new PrintStream(connectToServer.getOut(),true,"UTF-8");
                        out.println(jsonToSever);
                        //读取服务端发回的所有在线用户信息
                        Scanner in = new Scanner(connectToServer.getIn());
                        if(in.hasNextLine()){
                            String msgFromSeverStr = in.nextLine();
                            MessageVO msgFromSever = (MessageVO) CommUtils.JsonToObject(msgFromSeverStr,MessageVO.class);
                            Set<String> users = (Set<String>) CommUtils.JsonToObject(msgFromSever.getContent(),Set.class);
                            System.out.println("all user is:"+users);
                            //加载用户列表
                            //将当前用户名，所有在线好友，与服务器建立连接传递到好友列表界面
                            new FriendsList(userName,users,connectToServer);
                        }
                    } catch (UnsupportedEncodingException e1) {
                        e1.printStackTrace();
                    }
                }else{
                    //失败，停留登录页面，并提示错误信息
                    JOptionPane.showMessageDialog(frame,"登录失败","错误信息",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("用户登录");
        frame.setContentPane(new userLogin().userLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
