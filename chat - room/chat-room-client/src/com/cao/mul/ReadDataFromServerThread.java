package com.cao.mul;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ReadDataFromServerThread extends Thread {

    private final Socket client;
    public ReadDataFromServerThread(Socket client) {
        this.client = client;
    }


    @Override
    public void run() {
        try {
            InputStream inputStream = client.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (true) {
                String data = scanner.nextLine();
                System.out.println("来自服务端消息" + data);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
