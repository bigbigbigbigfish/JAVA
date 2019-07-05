package com.cao.day5;


public class Work {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    //检查 是否是回文结构
    public boolean chkPalindrome(ListNode A) {
        int len = length(A);
        int halfLen = length(A)/2;
        ListNode middle = A;
        for(int i = 0; i < halfLen; i++) {
            middle = middle.next;
        }
        ListNode r =reserve(middle);
        ListNode c1 = A;
        ListNode c2 = r;
        while (c1!= null && c2 != null) {
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
        ListNode cur =head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = result;
            result = cur;
            cur = next;
        }
        return result;
    }

    private int length(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
    // 移除链表中值为val的节点
    public ListNode removeElements(ListNode head, int val) {
       if(head ==null) {
           return null;
       }
       ListNode prev = head;
       ListNode cur = head.next;
       while (cur != null) {
           if(cur.val == val) {
               prev.next = cur.next;
               cur = cur.next;
           } else {
               prev = cur ;
               cur = cur.next;
           }
       }
       if(head.val ==val) {
           head = head.next;
       }
       return head;
    }
    //输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode fast = head;
        ListNode slow = head;
        int i;
        for(i = 0; fast != null && i<k-1; i++) {
            fast = fast.next;
        }
        if(fast == null && i < k) {
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


    //将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if( l1 ==null)  return l2;
        if( l2 == null) return  l1;

        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode last = null;
        ListNode result = null;

        while (c1 != null && c2 != null) {
            if(c1.val <= c2.val) {
                if(result == null) {
                    result = c1;
                } else {
                    last.next = c1;
                }
                last = c1;
                c1 = c1.next;
            } else {
                if(result == null) {
                    result = c2;
                } else {
                    last.next = c2;
                }
                last = c2;
                c2 = c2.next;
            }

        }
        if( c1 != null) {
            last.next = c1;
        } else {
            last.next = c2;
        }
        return result;
    }



    //编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    //给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变

    public ListNode partition(ListNode pHead, int x) {
        ListNode small = null;
        ListNode smallLast = null;
        ListNode big = null;
        ListNode bigLast = null;
        ListNode cur = pHead;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;


            //--------------------------
            if(cur.val < x) {
                if(small == null) {
                    small = cur;
                } else {
                    smallLast.next = cur;
                }
                smallLast = cur;
            } else {
                if(big == null ) {
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
        }
        return small;

    }
    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
    // 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode prev = dummy;
        ListNode p1 = pHead;
        ListNode p2 = pHead.next;
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
    //判断链表是否有环
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null) {
            fast = fast.next.next;;
            slow = slow.next;
            if(fast  == slow) {
                return true;
            }

        }
        return false;
    }

}
