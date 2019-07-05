package com.cao.day.day3;

public class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
        // write code here
        int len = length(A);
        int halfLen = len/2;
        ListNode middle = A;
        for(int i = 0 ;i<halfLen; i++) {
            middle = middle.next;
        }
       ListNode r =reserve(middle);
        ListNode c1 = A;
        ListNode c2 = r;
        while (c1 !=null && c2!= null) {
            if(c1.val != c2.val) {
                return false;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        return true;
    }

    private ListNode reserve(ListNode head) {
        ListNode result = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = result;
            result= cur;
            cur = next;
        }
        return result;
    }
    private int length(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while(cur!=null) {
            len++;
            cur= cur.next;
        }
        return len;
    }
}
