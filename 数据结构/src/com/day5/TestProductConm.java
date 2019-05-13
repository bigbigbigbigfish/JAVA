package com.day5;




import java.util.LinkedList;


public class TestProductConm {
    public static class Strong {

        private final int MAX_SIZE = 20;
        private LinkedList<Object> linkedList = new LinkedList<>();

        public LinkedList<Object> getList() {
            return linkedList;
        }

        public void setLinkedList(LinkedList<Object> linkedList) {
            this.linkedList = linkedList;
        }

        public int getMAX_SIZE() {
            return MAX_SIZE;
        }


        public void produce(int n) {
            synchronized (linkedList) {
                while (linkedList.size() + n > MAX_SIZE) {
                    System.out.println("要生产的数量: " + n + "/t 库存量" + linkedList.size() + "/t  暂时不能生产产品");
                    try {
                        linkedList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <= n; i++) {
                    linkedList.add(new Object());
                }
                System.out.println("已经生产的产品数: " + n + "库存量" + linkedList.size());
                linkedList.notifyAll();
            }
        }



        public void consume(int n) {
            synchronized(linkedList) {
                while (linkedList.size() < n) {
                    System.out.println("要消费的产品数量:" + n + "/t 库存量:" + linkedList.size() + " /t 暂时不能生产");
                }
                for (int i = 1; i < n; i++) {
                    linkedList.remove();
                }
                System.out.println("已经消费产品数 ;" + n + "/t  库存量" + linkedList.size());
                linkedList.notifyAll();
            }
        }
    }
    public static class Producer extends Thread {
        private int n;
        private Strong strong;

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public Strong getStrong() {
            return strong;
        }

        public void setStrong(Strong strong) {
            this.strong = strong;
        }

        public Producer(Strong strong) {
            this.strong = strong;
        }

        @Override
        public void run() {
            produce(n);
        }
        public void produce (int n) {
            strong.produce(n);
        }
    }
    public static class Consumer extends Thread {
        private int n;
        private Strong strong;

        public Consumer(Strong strong) {
            this.strong = strong;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public Strong getStrong() {
            return strong;
        }

        public void setStrong(Strong strong) {
            this.strong = strong;
        }
    }


    public static void main(String[] args) {
        Strong strong = new Strong();
        Producer p1 = new Producer(strong);
        Producer p2 = new Producer(strong);
        Producer p3 = new Producer(strong);
        Producer p4 = new Producer(strong);
        Producer p5 = new Producer(strong);




        Consumer c1= new Consumer(strong);
        Consumer c2= new Consumer(strong);
        Consumer c3= new Consumer(strong);
        Consumer c4= new Consumer(strong);

        c1.setN(20);
        c2.setN(10);
        c3.setN(5);


        c1.start();
        c2.start();
        c3.start();
    }
}
