package com.cao;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        final Queue<Goods> queue = new LinkedList<>();
        final Runnable produce = new Producer(queue);
        final Runnable customer = new Customer(queue);

//        for(int i = 0 ; i < 1; i++) {
//            new Thread(produce,"Thread - Produce - " + i).start();
//        }
//        for(int i =0 ;i<1 ;i++) {
//            new Thread(customer,"Thread -Customre - "+ i).start();
//        }
    }
}
