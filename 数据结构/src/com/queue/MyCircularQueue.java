package com.queue;

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

//public class MyCircularQueue {
//    private int front;
//    private int rear;
//
//    private int[] elem;
//
//    /** Initialize your data structure here. Set the size of the queue to be k. */
//    public MyCircularQueue(int k) {
//        this.elem = new int[k];
//        this.front =0;
//        this.rear = 0;
//
//
//
//    }
//
//    /** Insert an element into the circular queue. Return true if the operation is successful. */
//    public boolean enQueue(int value) {
//        if(isFull()) {
//            return false;
//        }
//        elem[rear] = value;
//        rear = (rear+1)%elem.length;
//        return true;
//    }
//
//    /** Delete an element from the circular queue. Return true if the operation is successful. */
//    public boolean deQueue() {
//        if (isEmpty()) {
//            return false;
//        }
//        elem[front] = 0;
//        front = (front+1)%elem.length;
//        return true;
//
//
//    }
//
//    /** Get the front item from the queue. */
//    public int Front() {
//        return elem[front];
//
//    }
//
//
//    /** Get the last item from the queue. */
//    public int Rear() {
//        if(isEmpty()) {
//            throw new UnsupportedOperationException("数组为空")
//        }
//        return
//    }
//
//    /** Checks whether the circular queue is empty or not. */
//    public boolean isEmpty() {
//        if(this.rear == this.front) {
//            return true;
//        }
//        return false;
//
//    }
//
//    /** Checks whether the circular queue is full or not. */
//    public boolean isFull() {
//        if((this.rear+1)% this.elem.length==this.front) {
//            return true;
//        }
//        return false;
//
//    }
//}

