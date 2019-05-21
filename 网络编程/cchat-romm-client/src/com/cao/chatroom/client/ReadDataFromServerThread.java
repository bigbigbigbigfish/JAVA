package com.cao.chatroom.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ReadDataFromServerThread extends Thread {
    private final Socket socket;
    public ReadDataFromServerThread(Socket socket) {

        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream  in = socket.getInputStream();
            Scanner scanner = new Scanner(in);
            while (true) {
                String data = scanner.nextLine();//阻塞操作
                System.out.println(data);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
