package com.day11;

public class MyLinked implements ILinked {

    class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    MyLinked(Node head) {
        this.head = head;
    }

    @Override
    public void addFirst(int data) {
        /***
         * 头插法
         */
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        //如果是第一次插入
        if(cur == null) {
            this.head = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;
                cur.next = node;
            }

        }
    }

//    private Node serchIndex(int index) {
//        Node cur = this.head;
//        for(int i =0; i<index-1; i++) {
//            cur = cur.next;
//
//        }
//
//    }




    @Override
    public boolean addIndex(int index, int data) {
        Node node = new Node(data);
        if(index == 0) {
            node.next = this.head;
            this.head = node;
        } else {
            Node cur = this.head;

            for(int i = 0; cur != null && i< index-1; i++) {
                cur = cur.next;
            }
            if(cur == null) {
                return false;
            }
            node.next = cur.next;
            cur.next = node;
        }
        return true;
    }


    @Override
    public boolean contains(int key) {
        Node cur = this.head;
       while (cur !=null) {
           if(cur.data == key) {
               return true;

           }
           cur = cur.next;
       }
       return false;
    }

    @Override
    public int remove(int key) {
        int oldData = 0;
        if(this.head == null) {
            return -1;
        } else if (this.head.data == key){
            oldData = this.head.data;
            this.head = this.head.next;
            return oldData;
        }
        Node prev = this.head;
        while (prev.next != null) {
            if(prev.next.data == key) {
                oldData = prev.next.data;
                prev.next =prev.next.next;
                return oldData;
            } else {
                prev =prev.next;
            }
        }
        return -1;
    }

    @Override
    public void removeAllKey(int key) {
        if(this.head == null) {
            return;
        }
        Node prev = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if(cur.data == key) {
                prev.next =cur.next;
                cur = cur.next;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
            if(prev.data == key) {
                prev = prev.next;
                cur = cur.next;
            }
        }

    }

    @Override
    public int getLength() {
        Node cur = this.head;
        int key = 0;
        while (cur != null) {
            key++;
            cur = cur.next;
        }
        System.out.println(key);
        return key;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data+ " ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while (head.next != null) {
            head.next = head.next.next;
        }
        this.head = null;

    }
}
