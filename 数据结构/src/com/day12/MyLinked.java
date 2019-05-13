package com.day12;

public class MyLinked implements ICLinked {


    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = next;
        }

        public Node() {
            this.data =-1;
            this.next = null;
        }
    }

    private Node head;

    public MyLinked(Node head) {
        this.head = new Node();
        this.head.next = this.head;
    }

    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = this.head.next;
        this.head.next = node;

    }

    @Override
    public void addLast(int data) {
        Node cur = this.head;
        while (cur != null) {
            cur = cur.next;
        }
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;





    }

    @Override
    public boolean addindex(int index, int data) {

    }

    private Node searchPrev(int key) {
        Node cur = this.head;
        while (cur.next != this.head) {
            if(cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head.next;
        while (cur != this.head) {
            if(cur.data == key) {
                return true;
            }
            cur =cur.next;
        }
        return false;
    }

    @Override
    public int remove(int key) {
        return 0;
    }

    @Override
    public void removeAllKey(int key) {

    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public void display() {
        Node cur = this.head;
        cur = this.head.next;
        while (cur != this.head) {
            System.out.print(cur.data+ " ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {

    }
}
