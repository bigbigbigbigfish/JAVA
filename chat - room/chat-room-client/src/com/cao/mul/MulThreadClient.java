package com.cao.mul;

import java.io.IOException;
import java.net.Socket;

public class MulThreadClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1",6666);
            new ReadDataFromServerThread(client).start();
            new WriterDataToServerThread(client).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
