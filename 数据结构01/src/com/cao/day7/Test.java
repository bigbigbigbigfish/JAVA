package com.cao.day7;

import java.util.List;

public class Test {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //输入：(2 -> 4 -> 3) +
    //      (5 -> 6 -> 4)
    //输出：7 -> 0 -> 8
    //原因：342 + 465 = 807
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode cur = dummy;
        int carry = 0;
        while (p1 != null ||p2 != null) {
            int x =(p1 != null)?p1.val : 0;
            int y =(p2 != null)?p2.val : 0;
            int sum = x+y+carry;
            carry = sum/10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(p1 != null) p1 = p1.next;
            if(p2 != null) p2 = p2.next;
        }
        if(carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;



    }
    //给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null && fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }




}
