package com.day1.thread;

/***
 *  继承thread  类实现run 方法
 *  */
 class MyThread implements Runnable{
    private String title ;
    public MyThread(String title) {
        this.title = title;
    }


    public void run() {
        for(int i = 0 ;i< 10 ;i++) {
            System.out.println("this.thread" + i);
        }
    }
}

public class TestThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("hehe");
            }
        }).start();
    }
}
