package com.cao.client.service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;

public class creatGroupGUI {
    private JPanel creatGroupGUI;
    private JPanel friendLabelPanel;
    private JTextField groupNameText;
    private JButton Button;

    private String myName;
    private Set<String> friends;
    private ConnectToServer connectToServer;


    public creatGroupGUI(String myName, Set<String> friends, ConnectToServer connectToServer) {

        this.myName = myName;
        this.friends = friends;
        this.connectToServer = connectToServer;


        JFrame frame = new JFrame("创建群组");
        frame.setContentPane(creatGroupGUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        //将在线好友以checkBox 展示到界面中
        friendLabelPanel.setLayout(new BoxLayout(friendLabelPanel,BoxLayout.Y_AXIS));
        JCheckBox[] checkBoxes = new JCheckBox[friends.size()];

        Iterator<String> iterator = friends.iterator();
        int i =0;
        while (iterator.hasNext()) {
            String labelName = iterator.next();
            checkBoxes[i] = new JCheckBox(labelName);
            friendLabelPanel.add(checkBoxes[i]);
            i++;
        }

        friendLabelPanel.revalidate();






















        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


}
