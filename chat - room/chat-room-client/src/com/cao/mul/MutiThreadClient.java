package com.cao.mul;


import java.io.IOException;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/***
 *  读取服务器发来的线程
 */
class ReadFromSrever implements Runnable {
    private Socket client;
    //通过构造方法传入通信的socket
    public ReadFromSrever(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        Scanner readFromeSever = null;
        try {
            readFromeSever = new Scanner(client.getInputStream());
            readFromeSever.useDelimiter("\n");
            while (true) {
                if(readFromeSever.hasNextLine()) {
                    String str = readFromeSever.nextLine();
                    System.out.println("服务器发来的消息为:" + str);
                }
                if(client.isClosed()) {
                    System.out.println("客户端已关闭!");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            readFromeSever.close();
        }
    }
}




class SendMsgToServer implements Runnable {
    private Socket client;

    public SendMsgToServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        PrintStream sendMsgToServer = null;
        try {
            /***
             *  获取输出流 向服务器发送信息
             */
            sendMsgToServer =
                    new PrintStream(client.getOutputStream(),true,"UTF-8");
            while (true) {
                System.out.println("请输入要发送的信息");
                if(in.hasNextLine()) {
                    String strToServer = in.nextLine();
                    sendMsgToServer.println(strToServer);
                    if(strToServer.contains("byebye")) {
                        System.out.println("关闭客户端");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            in.close();
            sendMsgToServer.close();
        }


    }
}

public class MutiThreadClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",6666);
        Thread readThread = new Thread(new ReadFromSrever(client));
        Thread sendThread = new Thread(new SendMsgToServer(client));
        readThread.start();
        sendThread.start();
    }
}
