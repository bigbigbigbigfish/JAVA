package com.cao.client.service;

import com.cao.util.CommUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Properties;

public class ConnectToServer {
    private static final String IP;
    private static final int PORT;

    static {
        Properties properties =CommUtils.loadProperties("socket.properties");
        IP =properties.getProperty("address");
        PORT = Integer.parseInt(properties.getProperty("port"));

    }
    private Socket client;
    private InputStream in;
    private OutputStream out;

    public ConnectToServer() {
        try {
            client= new Socket(IP,PORT);
            in = client.getInputStream();
            out = client.getOutputStream();
        } catch (IOException e) {
            System.err.println("与服务器建立连接失败");
            e.printStackTrace();
        }
    }

    public InputStream getIn() {
        return in;
    }

    public OutputStream getOut() {
        return out;
    }
}
