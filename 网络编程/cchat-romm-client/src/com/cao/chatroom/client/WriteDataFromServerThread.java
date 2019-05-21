package com.cao.chatroom.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriteDataFromServerThread extends Thread {
    private final Socket socket;
    public WriteDataFromServerThread(Socket socket) {

        this.socket = socket;
    }

    @Override
    public void run() {
        //TODO 客户端写数据
        try {
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String data = scanner.nextLine();
                outputStreamWriter.write(data + "\n");
                outputStreamWriter.flush();
                if("quit".equals(data)) {
                    break;
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
