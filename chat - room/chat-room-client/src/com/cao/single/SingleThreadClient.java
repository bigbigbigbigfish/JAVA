package com.cao.single;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadClient {
    public static void main(String[] args) {
        try {
            //1 单线程聊天室客户端  创建socket 客户端 ,连接指定服务器
            Socket socket = new Socket("127.0.0.1",6666);
            System.out.println("客户端创建 " + socket.getLocalAddress());
            //2 操作输入输出流
            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write("你好 服务器\n");
            writer.flush();

            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            String message = scanner.nextLine();
            System.out.println("接受服务器的消息" + message);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
