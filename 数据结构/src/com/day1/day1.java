package com.day1;

public class day1 {
    private static class ListNode {
        int val;
        ListNode next;
    }
    //private static ListNode Reverse(ListNode head) {
        //遍历原链表中的每一个节点，把每一个节点按头插的方式放到一个新链表中，新链表一开始为空，最后返回一个新链表

        //头插 把 node 头插到result 代表的链表中
        /**
         * node.next = result;
         * result = node;
         */
//        ListNode node = head;
//        ListNode result = null;
//        while (node != null) {
//            ListNode next =node.next
//            node.next =result;
//            result = node;
//            //因为node.next 被更改了值  所以需要提前记录
//            node = next; //这句基本是循环的最后一句
//        }
//        //返回逆置后链表的第一个节点
//        return result;
    //}

    private static ListNode Reserve2(ListNode head) {
        ListNode node = head;
        ListNode result = null;
        while ( node != null) {
            ListNode next = node.next;
            node.next = result;
            result = node;
            node =next;
        }
        return result;
    }

    private static ListNode merge(ListNode listA, ListNode listB) {
      if(listA == null) return listB;
      if(listB == null) return listA;
        // 原来的两个链表都是各自有序的
        // 合并完的链表需要整体有序
        // 同时遍历两个链表的各自节点
        //进行值的比较,哪个值比较小,选哪个节点放入到新链表中
        //放置的方式是尾插
        //当一个链表节点全部被取走
        //直接将剩余链表放到结果链表之后
        ListNode last = null;
        ListNode result =null;
        ListNode nA = listA;
        ListNode nB = listB;
        while ( nA != null && nB != null) {
            if(nA.val <= nB.val) {
                if(result == null){
                    result = nA;
                }else {
                    last.next =nA;
                }
                last =nA;
                nA = nA.next;
                } else{
                nB = nB.next;
            }
            if(nA.val>=nB.val) {
                if(result == null){
                    result = nB;
                }else {
                    last.next =nB;
                }
                last =nB;
                nB = nB.next;
            } else{
                nA = nA.next;
            }
        }

        //有一个链表的节点都取完了
        if(nA != null) {
            last.next = nA;
        } else{
            last.next = nB;
        }
        return result;

    }
}

