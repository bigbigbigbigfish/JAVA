package com.cao.day1.day2;

public class TestWait {

    public static void main(String[] args) {
        final Object object = new Object();
        Thread threadA = new Thread(()-> {
            System.out.println(Thread.currentThread().getName() + "执行同步块开始");
            synchronized (object) {
                try {
                    object.wait();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"执行同步块结束");
     });
        threadA.setName("thread -A");
        threadA.start();
        Thread threadB = new Thread(()-> {
            System.out.println(Thread.currentThread().getName() + "执行同步块开始");
            synchronized (object) {
                object.notify();
            }
            System.out.println(Thread.currentThread().getName()+"执行同步块结束");
        });
        threadB.setName("thread -B");
        threadB.start();
    }
}
