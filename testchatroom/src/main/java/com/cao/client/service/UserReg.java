package com.cao.client.service;

import com.cao.client.dao.AccountDao;
import com.cao.client.entiy.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class UserReg {
    private JPanel userRegPanel;
    private JLabel userName;
    private JLabel passWord;
    private JTextField userNameTextField;
    private JPasswordField passwordField1;
    private JTextField briefTextField;
    private JLabel brief;
    private JButton 注册;
    private AccountDao accountDao = new AccountDao();

    public UserReg(){
        JFrame frame = new JFrame("用户注册");
        frame.setContentPane(userRegPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        //点击注册按钮将信息持久化到DB中,成功弹出提示框
        注册.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取用户输入的注册信息
                String userName = userNameTextField.getText();
                String password = String.valueOf(passwordField1.getPassword());
                String brief = briefTextField.getText();
                User user = new User();
                user.setUserName(userName);
                user.setPassword(password);
                user.setBrief(brief);
                //调用dao对象
                if(accountDao.userReg(user)) {
                    //弹出提示框
                    JOptionPane.showMessageDialog(frame,"注册成功!","提示信息",JOptionPane.INFORMATION_MESSAGE);
                    frame.setVisible(false);
                    //与服务器简历连接,将当前用户的用户名发送到客户端


                } else {
                    //保留注册页面
                    JOptionPane.showMessageDialog(frame,"注册成功!","提示信息",JOptionPane.ERROR_MESSAGE);
                }


            }
        });
    }

}
