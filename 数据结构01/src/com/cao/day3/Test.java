package com.cao.day3;

public class Test {
    class Node{
        int val;
        Node next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    Node Reverse(Node head) {
        Node cur = head;
        Node result = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = result;
            result = cur;
            cur = next;
        }
        return result;
    }
    Node Merge(Node listA, Node listB) {
        Node p1 = listA;
        Node p2 = listB;
        //记录结果链表的最后一个节点
        Node last = null;
        //记录结果链表的第一个节点,可能是null
        Node result = null;
        while (p1 != null && p2 != null) {
            if(p1.val <p2.val) {
                if(result == null) {
                    result = p1;
                } else {
                    last.next = p1;
                }
                last = p1;
                p1 = p1.next;
            } else {
                if(p1.val > p2.val) {
                    if(result == null) {
                        result = p2;
                    } else {
                        last.next = p2;
                    }
                    last = p2;
                    p2 = p2.next;
                }
            }
            if(p1 != null) {
                last.next = p1;
            }else {
                last.next = p2;
            }
            // 有一个取完了;
        }
        return result;
    }

}
