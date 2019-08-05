package com.cao.day2;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThread {
    public static void main(String[] args) {

        RunnableThread runnableThread = new RunnableThread();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,5,2000,
                TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(runnableThread);
        }
    }


}


class RunnableThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "." + i);
        }
    }
}

