package com.cao.LaunchRedis;

import com.cao.Command.Command;
import com.cao.Databases.Permanent;
import com.cao.Procotol.ProtocolDecode;
import redis.clients.jedis.Protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        //从文件中加载资源
        Permanent.getPermanent().readFromListProfile();
        Permanent.getPermanent().readFromMapProfile();

        // 使用线程池处理并发用户情况

        ExecutorService executorService = Executors.newFixedThreadPool(20000);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6379);

            while (true) {
                final Socket socket = serverSocket.accept();
                executorService.execute(() -> {

                    try {
                        //持续提供业务服务
                        while (true) {
                            InputStream read = socket.getInputStream();
                            OutputStream write = socket.getOutputStream();

                            Command command = new ProtocolDecode(read, write).readCommand();
                            if(command!=null) {
                                command.run(write);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
