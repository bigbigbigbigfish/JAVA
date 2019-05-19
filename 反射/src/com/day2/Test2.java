package com.day2;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {

    }


    public class ListNode {
        int val;
        ListNode next =null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode partition(ListNode pHead, int x) {
            ListNode small = null;
            ListNode smallLast = null;
            ListNode big = null;
            ListNode bigLast = null;

            ListNode cur = pHead;
            while (cur != null) {
                ListNode next =cur.next;
                if(cur.val<x) {
                    if(small == null) {
                        small= cur;
                    } else {
                        smallLast.next =cur;
                    }
                    smallLast =cur;
                }else {
                    if(big == null) {
                        big = cur;
                    } else {
                        if(big ==null) {
                            big =cur;
                        }else {
                            bigLast.next = cur;
                        }
                    }
                    cur =next;
                }
            }
            if(small ==null) {
                return big;
            } else {
                small.next = big;
                return small;
            }

        }
    }



























}
