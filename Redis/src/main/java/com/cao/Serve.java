package com.cao;

import com.sun.corba.se.spi.activation.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serve {
    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    public void run(int port) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket socket = serverSocket.accept()){
                    logger.info("{} 已连接。",socket.getInetAddress().getHostAddress());

                    InputStream is =socket.getInputStream();
                    OutputStream os =socket.getOutputStream();

                    Command command = null;
                    while (true) {
                        try {
                            command = Protocol.readCommand(is);
                        } catch (Exception e) {
                            e.printStackTrace();
                            Protocol.writeError(os,"不识别的命令");
                        }
                    }
                }
            }

        }

    }
    public static void main(String[] args) throws IOException {
        new Serve().run(6376);
    }
}
