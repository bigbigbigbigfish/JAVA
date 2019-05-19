package com.cao.chatroom.client;

import java.io.IOException;
import java.net.Socket;

public class MultiThreadClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8080);
            //读
            new ReadDataFromServerThread(socket).start();






            // 写
            new WriteDataFromServerThread(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
