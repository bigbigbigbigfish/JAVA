package com.cao.chatroom.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleClient {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1",8080);
            // 读数据
            InputStream in = socket.getInputStream();
            Scanner scanner = new Scanner(in);
            String message = scanner.nextLine();
            System.out.println("来自服务器的数据:" + message);
            Thread.sleep(1000);
            //写数据
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println("你好 服务器");
            printStream.flush();
            socket.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
