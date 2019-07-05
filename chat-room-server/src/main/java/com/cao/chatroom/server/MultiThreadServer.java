package com.cao.chatroom.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("服务器启动" + serverSocket.getLocalSocketAddress() + ":" + serverSocket.getLocalPort());
            //线程池调度器
            final ExecutorService executorService = Executors.newFixedThreadPool(10);
            while (true) {
                final Socket socket = serverSocket.accept();
                executorService.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
