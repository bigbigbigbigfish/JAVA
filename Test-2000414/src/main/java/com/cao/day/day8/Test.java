package com.cao.day.day8;



public class Test {
    public static class ListNode {
        int val;
        ListNode next;
    }

    private static ListNode Reverse(ListNode head) { //遍历原链表中的每一个节点,把每一个节点按头插的方式 放到一个新的链表中,新链表一开始为null,返回新链表
        /***
         *  遍历链表的每一个节点
         */


//        for(ListNode node = head;node!= null;node = node.next){
//
//        }
        ListNode node= head;
        ListNode result = null; //result 记录链表的第一个节点,从而代表整个链表
        while (node !=null) {
            ListNode next = node.next;
            node.next = result;
            result = node;
            node = next;
        }
        return result;
    }





    private static ListNode Merge(ListNode listA,ListNode listB) {
        ListNode nA = listA;
        ListNode result = null;
        ListNode last = null;
        ListNode nB = listB;

        while (nA != null && nB != null) {
            if (nA.val <= nB.val) {
                if (result == null) {
                    result = nA;
                } else {
                    last.next = nA;
                }
                last = nA;
                nA = nA.next;
            } else {
                if (result == null) {
                    result = nB;
                } else {
                    last.next = nB;
                }
                last = nB;
                nB = nB.next;
            }

            if (nA != null) {
                last.next = nA;
            } else {
                last.next = nB;
            }

        }
        return result;
    }
    private int getLength(ListNode head) {
        int length = 0;
        for(ListNode cur = head; cur!= null; cur = cur.next) {
            length++;
        }
        return length;
    }
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        int lenA =getLength(headA);
//        int lenB =getLength(headB);
//
//        ListNode longer = headA;
//    }

//    ListNode copy(ListNode head) {
//        ListNode result = null;
//        ListNode cur = head;
//        while (cur!= null) {
//            ListNode newNode = new ListNode(cur.val);
//        }
//    }
//
//    class RNode {
//        int val;
//        RNode next;
//        RNode random; //链表中任意节点的因为或者为Null;
//    }

}
