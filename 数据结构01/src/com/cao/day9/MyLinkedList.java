package com.cao.day9;

public class MyLinkedList {

    class Node {
        Node next;
        Node prev;
        int val;

        public Node(int val) {

            this.val = val;
        }
    }
    Node head;
    Node last;

    public void addFirst(Node node) {
        node.next = this.head;
        this.head = node;
        if(this.last ==null) {
            this.last = node;
        }
    }

    public void removeFirst(Node node) {
        this.head = this.head.next;
        if(this.head == null) {
            this.last = null;
        }
    }



    public void addLast(Node node) {
        node.next = null;
        if(this.head == null) {
            this.head = this.last = node;
        } else {
            this.last.next = node;
            this.last = node;
        }
    }


    public void removeLast() {
        if(this.head.next == null) {
            this.head = this.last = null;
        } else {
            this.last.prev.next = null;
        }


    }

}
