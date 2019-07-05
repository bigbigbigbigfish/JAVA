//package com.cao;
//
//public class TestNotify {
//}
//
//
//class MyNotifyThread extends Thread {
//    private final Object monitor;
//
//    public MyThread(Object monitor) {
//        this.monitor = monitor;
//    }
//
//}
//
//    @Override
//    public void run() {
//        synchronized (this.monitor) {
//            System.out.println(Thread.currentThread().getName() + " 开始执行");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println();
//            this.monitor.notify();
//        }
//    }
//}
