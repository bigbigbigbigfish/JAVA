package com.cao.client.service;

import com.cao.util.CommUtils;
import com.cao.vo.MessageVO;

import javax.swing.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FriendsList {
    private JPanel friendsPan;
    private JScrollPane friendsList;
    private JButton createGroupBtn;
    private JScrollPane groupList;
    private JFrame frame;
    private String userName;
    private Set<String> users;
    private ConnectToServer connectToServer;





    private Map<String,PrivateChatGUI> privateChatGUIMapList = new ConcurrentHashMap<>();
    //好友列表后台任务,不断监听服务器发来的信息
    //好友上线信息, 用户私聊, 群聊

    private class DaemonTask implements Runnable {
        private Scanner in = new Scanner(connectToServer.getIn());

        @Override
        public void run() {
            while (true) {
                if(in.hasNextLine()) {
                    String strFromServer = in.nextLine();
                    if(strFromServer.startsWith("{")) {
                        MessageVO messageVO = (MessageVO) CommUtils.JsonToObject(strFromServer,MessageVO.class);
                        if(messageVO.getType().equals("2")) {
                            //服务器发来的私聊信息

                            String friendName = messageVO.getContent().split("-")[0];
                            String msg = messageVO.getContent().split("-")[1];
                            //判断此私聊是否是第一次创建

                            if(privateChatGUIMapList.containsKey(friendName)) {
                                PrivateChatGUI privateChatGUI = privateChatGUIMapList.get(friendName);
                                privateChatGUI.getFrame().setVisible(true);
                                privateChatGUI.readFromServer(friendName+"说" + msg);
                            } else {
                                PrivateChatGUI privateChatGUI = new PrivateChatGUI(friendName,userName,connectToServer);
                                privateChatGUIMapList.put(friendName,privateChatGUI);
                                privateChatGUI.readFromServer(friendName+"说"+msg);
                            }
                        }
                    } else {
                        if(strFromServer.startsWith("newLogin")) {
                            String newFrinndName = strFromServer.split(":")[1];
                            users.add(newFrinndName);
                            JOptionPane.showMessageDialog(frame,newFrinndName+"上线了","好友的上线提醒",JOptionPane.INFORMATION_MESSAGE);
                            loadUsers();
                        }
                    }
                }
            }
        }
    }



    private class PrivateLabelAction implements MouseListener{
        public PrivateLabelAction(String labelName) {
            this.labelName = labelName;
        }

        private String labelName;
        @Override
        public void mouseClicked(MouseEvent e) {
            //判断好友列表的私聊界面的缓存是否有指定标签

            if(privateChatGUIMapList.containsKey(labelName)) {
                PrivateChatGUI privateChatGUI = privateChatGUIMapList.get(labelName);
                privateChatGUI.getFrame().setVisible(true);
            } else {
                PrivateChatGUI privateChatGUI = new PrivateChatGUI( labelName,userName,connectToServer) {

                };

                privateChatGUIMapList.put(labelName,privateChatGUI);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }


    public FriendsList(String userName, Set<String> users,ConnectToServer connectToServer ) {
        this.userName = userName;
        this.users = users;
        this.connectToServer = connectToServer;

        frame = new JFrame("userName");
        frame.setContentPane(friendsPan);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        loadUsers();

        //启动后台线程不断监听服务器发来的信息

        Thread daemonThread = new Thread(new DaemonTask());
        daemonThread.setDaemon(true);
        daemonThread.start();
    }
    //加载所有在线的用户信息
    public void loadUsers(){
        JLabel[] userLabels = new JLabel[users.size()];
        JPanel friends = new JPanel();
        //set遍历
        friends.setLayout(new BoxLayout(friends,BoxLayout.Y_AXIS));
        Iterator<String> iterator = users.iterator();
        int i = 0;
        while(iterator.hasNext()){
            String userName = iterator.next();
            userLabels[i] = new JLabel(userName);
            //添加标签点击事件
            userLabels[i].addMouseListener(new PrivateLabelAction(userName));
            friends.add(userLabels[i]);
            i++;
        }
        friendsList.setViewportView(friends);
        //设置滚动条垂直滚动
        friendsList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //刷新界面
        friends.revalidate();
        friendsList.revalidate();
    }
}
