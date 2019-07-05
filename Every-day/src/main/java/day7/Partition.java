package day7;

import java.util.Scanner;

public class Partition {


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode partition(ListNode pHead, int x) {
        ListNode small = null;
        ListNode smallLast = null;
        ListNode big = null;
        ListNode bigLast = null;
        ListNode cur = pHead;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            if(cur.val < x) {
                if(small == null) {
                    small = cur;
                } else {
                    smallLast.next = cur;
                }
                smallLast = cur;
            } else {
                if(big == null) {
                    big = cur;
                } else {
                    bigLast.next = cur;
                }
                bigLast = cur;
            }
            cur =next;
        }
        if(small == null) {
            return big;
        } else {
            smallLast.next = big;
        }
        return small;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }

}
