package com.cao.day10;

public class MyLinkedList {
    class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node last;

    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null) {

        }


    }

    //尾插法
    private void addLast(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }

    }
    private Node searchIndex(int index) {
        checkIndex(index);
        int count = 0;
        Node cur = this.head;
        while(count != index) {
            cur = cur.next;
            count++;//1  2
        }
        return cur;
    }

    private void checkIndex(int index) {
        if(index < 0 || index > getLength()){
            throw new UnsupportedOperationException("index位置不合法");
        }
    }


    public boolean addIndex(int index, int data) {
        if(index == 0) {
            addFirst(data);
            return true;
        }
        if(index == getLength()){
            addLast(data);
            return true;
        }
        Node cur = searchIndex(index);
        //cur 指向index位置的节点
        Node node = new Node(data);
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;

        return true;
    }



    //任意位置插入,第一个数据节点为0号下标
    public boolean addindex(int index, int data) {
        return true;


    }

    //查找是否包含关键字key是否在单链表当中
    boolean contains(int key) {
        Node cur = this.head;
        if(cur.val == key) {
            return true;
        }
        return false;

    }

    //删除第一次出现关键字为key的节点
    public int remove(int key) {
        Node cur = this.head;
        int oldData = 0;
        while(cur != null) {
            if(cur.val == key) {
                oldData = cur.val;
                //头结点
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    //cur.next != null -->不是尾节点
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else {
                        this.last = cur.prev;
                    }
                }
                return oldData;
            }
            cur = cur.next;
        }
        return -1;
    }


    //删除所有值为key的节点
    void removeAllKey(int key) {
        Node cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }

    }

    //得到单链表的长度
    int getLength() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;

    }

    void display() {

    }

    void clear() {
        while (this.head != null) {
            Node cur = this.head.next;
            this.head.next = null;
            this.head.prev = null;
            this.head = cur;
        }
        //尾结点的引用需要释放
        this.last = null;
    }

}


