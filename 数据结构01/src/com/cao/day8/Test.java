package com.cao.day8;

public class Test {


    private class Node {
        int v;
        Node next;

        public Node(int v) {
            this.v = v;
        }
    }

    private Node head;


    public void addFirst(int v) {
        Node node = new Node(v);
        node.next = this.head;
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
            }
            last.next = node;
        }
    }


    boolean addIndex(int index,int v) {
        Node node = new Node(v);
        if (index == 0) {
            node.next = this.head;
            this.head = node;
        } else {
            Node cur = this.head;
            for (int i = 0; cur != null && i < index - 1; i++) {
                cur = cur.next;
            }
            if (cur == null) {
                return false;
            }
            node.next = cur.next;
            cur.next = node;
        }
        return true;
    }
    public void remove(int v) {
        if(this.head == null) {};
        if(this.head.v == v) {
            this.head = this.head.next;
        } else {
            Node prev = this.head;
            while (prev.next != null) {
                if (prev.next.v == v) {
                    prev.next = prev.next.next;
                }
            }
        }
    }












    public boolean contains(int v) {
        for(Node c = this.head; c != null;c =c.next){
            if(c.v ==v) {
                return true;
            }
        }
        return false;
    }
}
