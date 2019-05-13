package com.cao.day2;


class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
public class Nowcoder {
    public class Partition {
        public ListNode partition(ListNode pHead, int x) {
            ListNode small = null;
            ListNode big = null;
            //小于等于x的最后一个节点
            ListNode smallLast = null;
            // 大于等于x的最后一个节点
            ListNode bigLast = null;

            // write code here
            ListNode cur = pHead;
            while (cur != null) {
                ListNode next = cur.next;
                if(cur.val < x) {
                    cur.next = null;
                    //把cur尾插到small上
                    if(small == null) {
                        small = cur;
                    } else {
                        smallLast.next = cur;
                    }
                    smallLast = cur;
                }
                if(cur.val > x) {
                    cur.next = null;
                    //把cur尾插到small上
                    if(big == null) {
                        big = cur;
                    } else {
                        bigLast.next = cur;
                    }
                    bigLast = cur;
                }
                cur = next;
            }
            if(small == null) {
                return big;
            } else {
                smallLast.next = big;
                return small;
            }


        }
    }


    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if(fast.next == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode fast = head;
        ListNode slow = head;
        int i;
        for(i = 0; fast != null&& i < k-1; i++) {
            fast = fast.next;
        }
        if(fast == null && i < k) {
            return null;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }
    public boolean chkPalindrome(ListNode A) {
        int len = length(A);
        int halfLen = len/2;


        ListNode middle = A;
        for(int i = 0; i < halfLen; i++) {
            middle = middle.next;
        }

        ListNode r = reserve(middle);
        ListNode c1 =A;
        ListNode c2 = r;
        while (c1 != null && c2 !=null) {
            if(c1.val != c2.val) {
                return false;
            }
        }
        return true;

    }

    public ListNode deleteDuplication(ListNode pHead) {
        //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
        // 重复的结点不保留，返回链表头指针。
        // 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
        if(pHead == null) {
            return null;
        }
        ListNode prev = null;
        ListNode slow = pHead;
        ListNode fast = pHead.next;
        while (fast.next == null) {
            if(fast.val != slow.val) {
                prev = prev.next;
                slow = slow.next;
                fast = fast.next;
            } else {
                while (fast != null && fast.val != slow.val) {
                    fast = fast.next;
                }
                prev.next = fast;
                slow = fast;
                if(fast != null) {
                    fast = fast.next;
                }
            }
        }
        return slow;
    }


    public ListNode removeElements(ListNode head, int val) {
        ListNode result = null;
        ListNode cur = head;
        ListNode last = null;
        while(cur != null) {
            ListNode next =cur.next;
            if(cur.val != val) {
                cur.next = null;
                if(result == null) {
                    result = cur;
                } else{
                    last.next = cur;
                }
                last = cur;
            }
            cur = next;
        }
        return result;
    }







    public ListNode reserve(ListNode head) {
        ListNode reslut = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = reslut;
            reslut = cur;
            cur = next;
        }
        return reslut;
    }




    public int length(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }
        return len;
    }
}
