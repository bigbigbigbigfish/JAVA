package com.cao;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 *
 */

public class Hello {

    public static void main(String[] args) {

    }

}


class Goods {
    private int maxGoodsNum;
    private int currentNum;
    private Lock lock = new ReentrantLock();
    //生产者等待队列
    private Condition producerQueue = lock.newCondition();
    //消费者等待队列
    private Condition consumerQueue = lock.newCondition();
    public Goods (int maxGoodsNum) {
        this.maxGoodsNum = maxGoodsNum;
    }



    public void produceGoods() {
        try {
            lock.lock();
            while (this.currentNum == maxGoodsNum) {
                producerQueue.await();
            }
            System.out.println("...");
            currentNum++;
        } catch (Exception e) {

        }finally {
            lock.unlock();
        }
    }

}