package com.day4;

public class Test {

    static class Node {
        Node next;
        int val;

        Node( int v) {
            this.val = v;
        }
    }

    class RNode {
        int val;
        public RNode random;
        public RNode next;
        RNode(int v) {
            this.val = v;
        }
    }
    private static void display(Node head) {
        for (Node n = head; n!= null; n = n.next) {
            System.out.format("%d-->",n.val);
        }
        System.out.println("null");
    }

    private static void test1() {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(4);
        Node n6 = new Node(5);
        Node n7 = new Node(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = null;
        display(n1);
        Node r =deleteDuplicate(n1);
        display(r);

    }






    public static void main(String[] args) {
        test1();
    }

    private static Node deleteDuplicate(Node head) {
        if(head == null) {
            return null;
        }
        Node prev = null;
        Node p1 = head;
        Node p2 = head.next;
        while (p2 != null) {
            if(p1.val != p2.val) {
                prev = p1;
                p1 = p1.next;
                p2 = p2.next;
            } else {
                while (p2 != null && p2.val == p1.val) {
                    p2 = p2.next;
                }
                if(p1 == head) {
                    head = p2;
                } else {
                    prev.next = p2;
                }
                p1 = p2;
                if(p2 != null) {
                    p2 = p2.next;
                }
            }
        }
        return head;

    }
//    RNode copyRandomList(RNode head) {
//        /***
//         * 创建新节点 插到老节点后面
//         * 设置random
//         * 拆开
//         */
//
//        RNode cur = head;
//        while (cur != null) {
//
//        }
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
//    }

}


