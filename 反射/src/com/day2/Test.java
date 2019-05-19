package com.day2;

public class Test {
    public Test() {
        this.head = null;
    }

    public static class Node {
        public int value;
        public Node next;
        Node(int value) {
            this.value = value;
            this.next =null;
        }
    }

    public Node head;

    public Test(Node head) {
        this.head = null;
    }
    //头插
    void pushFront(Node node) {
        node.next = this.head;
        this.head = node;
    }

    //尾插
    void pushBack(Node node) {
        if(this.head == null) {
            this.head = node;
        } else {
            Node last =getLast();
            last.next = node;

        }
    }
    //  查找链表中最后一个节点
    private Node getLast() {
        if(this.head ==null) {
            throw new Error();
        }
            Node last = this.head;
            while (last.next != null){
                last = last.next;
            }
        return last;
    }

    //循环遍历每一个节点
    public void display(){
        Node cur = this.head;
        while (cur != null) {
            System.out.format("%d--->", cur.value);
            cur = cur.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Test list = new Test();
        list.pushBack(new Node(10));
        list.pushBack(new Node(20));
        list.pushBack(new Node(30));
        list.pushFront(new Node(22));
        list.display();

    }




}
