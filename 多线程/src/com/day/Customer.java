package com.day;

import java.util.Queue;

public class Customer implements Runnable {
    private final Queue<Goods> queue;

    Customer(Queue<Goods> queue) {

        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.queue){
                if(this.queue.isEmpty()){
                    System.out.println(Thread.currentThread().getName()+" 容器已空 开始生产");
                    this.queue.notifyAll();
                } else {
                    Goods goods = this.queue.poll();
                    if(goods != null) {
                        System.out.println(Thread.currentThread().getName()+"消费商品" + goods);
                    }
                }
            }
        }
    }
}
