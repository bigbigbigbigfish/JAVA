//package com.day4;
//
//public class Queue {
//    private class Node {
//        int value;
//        Node next;
//    }
//
//    Node head;
//    Node last;
//
//    Queue(){
//        this.head = this.last = null;
//    }
//
//    public void push(int v) {
//        /***
//         * 入队列
//         *
//         */
//
//
//        Node node = new Node();
//        node.value = v;
//        node.next = null;
//        if(this.head ==null) {
//            this.head = this.last = node;
//        } else {
//            this.last.next = this.last = node;
//        }
//    }
//
//
//
//
//
//
//    public int pop(int v) {
//        /***
//         * 出队列
//         */
//
//        int v = this.head.value;
//        this.head =this.head.next;
//        if(this.head == null) {
//            this.last = null;
//        }
//        return v;
//    }
//
//
//
//
//
//
//
//    public int size() {
//
//    }
//
//
//
//
//
//
//
//    public boolean isEmpty() {
//        return this.head ==null;
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
