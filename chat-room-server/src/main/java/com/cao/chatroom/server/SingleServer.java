package com.cao.chatroom.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleServer {
    public static void main(String[] args) {
        try {
            // 实例化serversocket 对象
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("服务器启动" + serverSocket.getLocalSocketAddress() + ":" + serverSocket.getLocalPort());
            while (true) {
                // 等待客户端连接
                //accept : 阻塞方法, 直到客户端连接到服务器才返回
                final Socket socket = serverSocket.accept();
                System.out.println("来自客户端: " + socket.getRemoteSocketAddress() + ":" + socket.getPort());
                // 3数据传输
                // 3.1 写数据
                OutputStream outputStream = socket.getOutputStream();
                PrintStream printStream = new PrintStream(outputStream);
                printStream.println("欢迎你 客户端");
                printStream.flush();

                //3.2 读数据
                InputStream in = socket.getInputStream();
                Scanner scanner = new Scanner(in);
                String message = scanner.nextLine();
                System.out.println("来自客户端的数据:" + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
