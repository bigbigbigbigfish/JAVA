package com.cao.mul;



import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//使用内部类
public class MultiThreadServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            ExecutorService service = Executors.newFixedThreadPool(20);
            for(int i = 0;i < 20;i++) {
                System.out.println("等待客户端连接");
                Socket client = serverSocket.accept();
                System.out.println("有新的客户端连接,端口号为" + client.getPort());
                service.submit(new ExectueClientRequest(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /***
     * 保证线程安全
     */
    private static Map<String,Socket> clientsMap = new ConcurrentHashMap<>();
    static class ExectueClientRequest implements Runnable {
        /***
         * 1
         */
        private Socket client;

        public ExectueClientRequest(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            //获取输入流,不断的读取用户发来的信息
            try {
                Scanner readFromClient = new Scanner(client.getInputStream());
                readFromClient.useDelimiter("\n");

                while (true) {
                    if(readFromClient.hasNextLine()) {
                        String str = readFromClient.nextLine();
                        Pattern pattern = Pattern.compile("\r");
                        Matcher matcher = pattern.matcher(str);
                        str = matcher.replaceAll("");
                        /***
                         * 用户注册:
                         * userName: zhangsan
                         *
                         * 群聊:
                         * G:hello i an...
                         * 私聊:
                         * P: zhangsan-hello i am..
                         */
                        if(str.startsWith("userName")) {
                            //用户的注册流程
                            String userName = str.split(":")[1];
                            userRegister(userName,client);
                            continue;
                        }else if(str.startsWith("G")) {
                            String msg = str.split("G:")[1];
                            groupChat(msg);
                            continue;
                        }else if (str.startsWith("P")) {
                            String tempMsg = str.split(":")[1];
                            String userName = tempMsg.split("-")[0];
                            String privateMsg = tempMsg.split("-")[1];
                            privateChat(userName,privateMsg);
                            continue;

                        }else if(str.contains("byebye")) {
                            String userName = str.split(":")[0];
                            userExit(userName);
                            continue;

                        }



                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        /***
         *
         * @param userName 用户注册名
         * @param client  对应的Socket
         */
        private void userRegister(String userName, Socket client) {
            //将用户信息保存到服务器中
            clientsMap.put(userName,client);
            int size = clientsMap.size();
            System.out.println("当前聊天室内共有" + size + "人");
            String userOnline = userName+"上线了!";
            groupChat(userOnline);
        }

        /***
         *
         * @param msg 要发送的群聊信息
         */
        private void groupChat(String msg) {
            //取出所有连接的客户端,依次拿到输出流进行遍历输出
            Collection<Socket> clients = clientsMap.values();
            for(Socket client : clients) {
                try {
                    PrintStream out = new PrintStream(client.getOutputStream());
                    out.println("群聊信息为:" + msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        /***
         *
         * @param userName 私聊的用户名
         * @param msg 私聊的用户信息
         */
        private void privateChat(String userName,String msg) {
            Socket client = clientsMap.get(userName);
            try {
                PrintStream out = new PrintStream(client.getOutputStream(),true,"UTF-8");
                out.println("私聊信息为"+ msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /***
         *
         * @param userName 退出的用户名
         */
        private void userExit(String userName) {
            clientsMap.remove(userName);
            System.out.println("当前聊天室的人数为" + clientsMap.size());
            String groupChatMsg =userName + "已下线";
            groupChat(groupChatMsg);
        }
    }

}
