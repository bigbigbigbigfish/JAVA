package com.cao.mul;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriterDataToServerThread extends Thread{

    private final Socket client;

    public WriterDataToServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            OutputStream outputStream = client.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String data =scanner.nextLine();
                writer.write(data+"\n");
                writer.flush();
                if(data.equals("byebye")) {
                    break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
