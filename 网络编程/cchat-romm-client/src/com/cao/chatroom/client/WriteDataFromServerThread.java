package com.cao.chatroom.client;

import java.net.Socket;

public class WriteDataFromServerThread extends Thread {
    private final Socket socket;
    public WriteDataFromServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //TODO 客户端写数据
    }
}
