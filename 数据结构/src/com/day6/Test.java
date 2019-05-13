package com.day6;

/***
 *  双引用
 *  给定一个带有头结点的非空链表,返回链表的中间节点
 *  如果有两个中间节点,则返回第二个中间节点
 */
public class Test {

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}


class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if(fast.next == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}