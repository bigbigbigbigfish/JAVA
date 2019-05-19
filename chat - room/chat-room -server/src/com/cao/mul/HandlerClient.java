package com.cao.mul;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class HandlerClient implements Runnable {
    /***
     * 维护所有的连接到服务端的对象
     */

    private static final Map<String,Socket> ONLINE_CLOENT_MAP = new ConcurrentHashMap<>();
    private final Socket client;
    public HandlerClient(Socket client) {
        this.client = client;
    }
    @Override
    public void run() {
        try {
            InputStream clientInput= client.getInputStream();
            Scanner scanner = new Scanner(clientInput);

            /***
             * 消息是按行读取
             * 1 register:<userName>张三
             * P  私聊
             * G 群聊
             */
            while (true) {
                String data =scanner.nextLine();
                if(data.startsWith(":")) {
                    String userName = data.split("register:")[1];
                    register(userName);
                    continue;

                } else if(data.startsWith("groupChat:")) {
                    String userName = data.split(":")[1];
                    groupChat(userName);
                    continue;
                } else if(data.startsWith("privateChat:")) {
                    String[] segments = data.split(":");
                    String targetUserName = segments[1];
                    String message = segments[2];
                    privateChat(targetUserName,message);
                    continue;
                } else if(data.equals("byebye")) {
                    bye();
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void sendMessage(Socket target, String message) {
        OutputStream clientOutput =null;
        try {
            clientOutput = target.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(clientOutput);
            writer.write(message+"\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /***
     * 当前客户端退出
     */
    private void bye() {
        for (Map.Entry<String ,Socket> entry :ONLINE_CLOENT_MAP.entrySet()) {
            Socket target = entry.getValue();
            if(target.equals(client)) {
                ONLINE_CLOENT_MAP.remove(entry.getKey());
                break;
            }
        }
        printOnlineClient();
    }

    /***
     * 私聊给targetUserName
     * 发送Message
     * @param targetUserName
     * @param message
     */
    private void privateChat(String targetUserName, String message) {
        Socket target = ONLINE_CLOENT_MAP.get(targetUserName);
        if(target == null) {
            this.sendMessage(client,"没有这个人" + targetUserName);
        } else {
            sendMessage(target,message);
        }

    }

    /***
     * 群聊发送messaage
     * @param message
     */
    private void groupChat(String message) {
        for(Map.Entry<String,Socket> entry:ONLINE_CLOENT_MAP.entrySet()) {
            Socket target = entry.getValue();
            if(target.equals(client)) {
                continue;
            }
            sendMessage(target,message);

        }
    }

    /***
     * 注册以userName 为key 当前用户
     * @param userName
     */
    private void register(String userName) {
        ONLINE_CLOENT_MAP.put(userName,client);
        printOnlineClient();
        sendMessage(client,"恭喜"+ "消息发送成功");
    }

    private void printOnlineClient() {
        System.out.println("当前在线人数" + ONLINE_CLOENT_MAP.size()+"用户名如下列表");
        for (String userName: ONLINE_CLOENT_MAP.keySet()) {
            System.out.println(userName);
        }
    }






}
