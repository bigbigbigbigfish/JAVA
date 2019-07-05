package com.cao.day.day8;


import java.util.concurrent.*;

public class Testt {
    public static void main(String[] args) {
        Mythread mythread =new Mythread();
        //必须写的 池大小 ,最大大小  空间时间,  单位  采用什么策略
        ExecutorService executorService = new ThreadPoolExecutor(3,5,
                2000,TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        for(int i =0;i<5;i++) {
           Future future = executorService.submit(mythread);
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}


class Mythread implements Callable {
    @Override
    public Object call() throws Exception {
        for(int i = 0;i<10;i++) {
            System.out.println(Thread.currentThread().getName() +"," +i);
        }
        return Thread.currentThread().getName()+"执行结束";
    }
//    public void run() {
//        for(int i = 0;i<10;i++) {
//            System.out.println(Thread.currentThread().getName()+","+i);
//        }
//    }
}