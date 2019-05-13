package com.day4;

public class MyLinkedList {
    private class Node {
        int val;
        Node next;
        Node(int v) {
            this.val = v;
        }
    }


    private Node head;


    public void addFirst(int v) {
        Node node = new Node(v);
        node.next =this.head;
        this.head = node;
    }




    public void addLast(int v) {
        Node node = new Node(v);
        node.next = null;
        if(this.head == null) {
            this.head = node;
        } else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
                last.next = node;
            }
        }
    }


//    boolean addIndex(int index, int v) {
//        Node node = new Node(v);
//        if(index == 0) {
//            node.next = this.head;
//            this.head = node;
//        } else {
//            Node cur = this.head;
//            for(int i = 0; cur != null&&i<index-1;i++ ) {
//                cur = cur.next;
//            }
//            if(cur == null) {
//                return false;
//            }
//            node.next = cur.next;
//            cur.next = node;
//        }
//        return true;
//    }
    public boolean contains(int v) {
        for(Node c = this.head; c != null;c = c.next) {
            if( c .val ==v ) {
                return true;
            }
        }
        return false;
    }

    public void remove(int v) {
        if (this.head == null) {

        } else if (this.head.val == v) {
            this.head = this.head.next;
        } else {
            Node prev = this.head;
            while (prev.next != null) {
                if (prev.next.val == v) {
                    prev.next = prev.next.next;
                }
            }
        }

    }
}