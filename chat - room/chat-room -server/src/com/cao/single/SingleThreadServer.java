package com.cao.single;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadServer {
    public static void main(String[] args) {
        try {
            //1 指定端口,监听6666端口
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("服务器启动" + serverSocket.getLocalSocketAddress());
            //2 阻塞式等待连接
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("接受到客户端连接  " + socket.getLocalAddress());
                        //3 操作输入输出流
                        // 1) 接受数据
                        InputStream inputStream = null;
                        try {
                            inputStream = socket.getInputStream();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Scanner scanner = new Scanner(inputStream);
                        String message = scanner.nextLine();
                        System.out.println("收到客户端消息" + message);
                        // 2) 发送数据
                        OutputStream outputStream = null;
                        try {
                            outputStream = socket.getOutputStream();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
                        try {
                            writer.write("你好 客户端 我很好。\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            writer.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //关闭

//                        try {
//                            //serverSocket.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
                        System.out.println("服务器关闭");
                    }
                }).start();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
