package com.cao.day6;


public class Test {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findKthTotail (ListNode head,int k) {
        ListNode fast = head;
        ListNode slow = head;
        int i;
        for (i = 0; i < k-1; i++) {
            fast = fast.next;
        }if( fast == null && i< k) {
            return null;
        } else if(fast == null) {
            return head;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reserve(ListNode head) {
        ListNode result = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = result;
            result = cur;
            cur = next;
        }
        return result;
    }

    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
    // 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

    public ListNode deleteDuplication(ListNode head){
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null) {
            if(p1.val != p2.val) {
                prev = prev.next;
                p1 = p1.next;
                p2 = p2.next;
            } else {
                while (p2 != null && p2.val == p1.val) {
                    p2 = p2.next;
                }
                p1 = p2;
                if(p2 != null) {
                    p2 = p2.next;
                }
            }
        }
        return dummy.next;
    }
}
