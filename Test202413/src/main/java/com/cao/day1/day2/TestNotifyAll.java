package com.cao.day1.day2;

public class TestNotifyAll {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
          final Object object = new Object();
            @Override
            public void run() {
                synchronized (object) {

                }

            }
        };















    }
}
