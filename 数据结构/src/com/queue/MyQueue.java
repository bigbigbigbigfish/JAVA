package com.queue;

public class MyQueue implements IQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.add(1);
        myQueue.add(2);
        System.out.println(myQueue.peek());
    }

    class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int useSize;


    @Override
    public boolean empty() {
        return useSize == 0;
    }

    @Override
    public int peek() {
        if(empty()) {
            throw new UnsupportedOperationException("队列为空");
        }
        return this.front.data;
    }

    @Override
    public int poll() {
        int oldData;
        oldData = front.data;
        if(empty()) {
            throw new UnsupportedOperationException("队列为空");
        }
        else {
            this.front = this.front.next;
            this.useSize--;
        }
        return oldData;
    }

    @Override
    public void add(int item) {
        Node node = new Node(item);
        if (empty()) {
            this.front = node;
            this.rear = node;
        } else {
            this.rear.next = node;
            this.rear = node;

        }
        this.useSize++;

    }

    @Override
    public int size() {
        return this.useSize;
    }
}
