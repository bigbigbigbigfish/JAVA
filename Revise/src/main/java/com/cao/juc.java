package com.cao;

import java.util.concurrent.CountDownLatch;

public class juc {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        CDLTask cdlTask = new CDLTask(countDownLatch);
        System.out.println("_------------");
        new Thread(cdlTask,"A").start();
        new Thread(cdlTask,"B").start();
        new Thread(cdlTask,"c").start();
        new Thread(cdlTask,"D").start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class CDLTask implements Runnable {
    CountDownLatch countDownLatch;
    public CDLTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    public void run() {

    }

}
