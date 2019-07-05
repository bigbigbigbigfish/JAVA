package com.cao.chatroom.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class ClientHandler implements Runnable {
    //存储所有的注册到服务端的客户端
    private static final Map<String,Socket>  SOCKET_MAP= new ConcurrentHashMap<>();
    private final Socket client;
    private String name;
    ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        // 此处服务器socket 和客户端socket进行数据传输
        // 业务逻辑
        try {
            InputStream in = this.client.getInputStream();
            Scanner scanner = new Scanner(in);
            while (true) {
                String line = scanner.nextLine();
                if(line.startsWith("register")) {
                    //register:<name>
                    String[] segment = line.split(":");
                    if(segment[0].equals("register")) {
                        String name = segment[1];
                        resigter(name);
                    }
                    continue;
                }
                if(line.startsWith("group:")) {
                    //TODO 群聊功能
                    //group: hello
                    //String[] segments = line.split(":");
                    String message = line.split(":")[1];

                    groupChat(message);
                    continue;

                }
                if(line.startsWith("private:")) {
                    //TODO 私聊功能
                    //private:name-
                    String[] argments = line.split(":");
                    String tempMessage = line.split(":")[1];
                    String targetName = tempMessage.split("-")[0];
                    String message = tempMessage.split("-")[1];
                    privateChat(targetName,message);
                    continue;
                }
                if(line.equals("quit")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void privateChat(String targetName, String message) {
        Socket target = SOCKET_MAP.get(targetName);
        if(target == null) {
            System.out.println("没有这个人");
        } else {
            sendMessage(target,message);
        }
    }

    private void groupChat(String message) {
        for(Map.Entry<String,Socket> entry:SOCKET_MAP.entrySet()) {
            Socket target = entry.getValue();
            if(target.equals(client)) {
                continue;
            }
            sendMessage(target,message);
        }
    }

    private void  sendMessage(Socket socket,String message) {
        try {
            OutputStream out = socket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println(message);
            printStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void quit() {
        SOCKET_MAP.remove(this.name);
        this.printOnlineClient();
    }


    private void resigter(String name) {
        // 表示当前客户端注册的名称 和连接的socket
        this.name = name;
        SOCKET_MAP.put(name,this.client);
        sendMessage(client, "恭喜"+name+"注册成功");
        printOnlineClient();
    }

    private void printOnlineClient() {
        System.out.println("当前在线人数" + SOCKET_MAP.size() + " 名称如下");
        for(String name : SOCKET_MAP.keySet()) {
            System.out.println(name);
        }
    }

}
