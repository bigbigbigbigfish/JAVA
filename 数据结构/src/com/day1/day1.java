package com.day1;

public class day1 {
    private static class ListNode {
        public ListNode(int val) {
            this.val = val;
        }

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
        while (node != null) {
            ListNode next = node.next;
            node.next = result;
            result = node;
            node = next;
        }
        return result;
    }

    private static ListNode merge(ListNode listA, ListNode listB) {
        if (listA == null) return listB;
        if (listB == null) return listA;
        // 原来的两个链表都是各自有序的
        // 合并完的链表需要整体有序
        // 同时遍历两个链表的各自节点
        //进行值的比较,哪个值比较小,选哪个节点放入到新链表中
        //放置的方式是尾插
        //当一个链表节点全部被取走
        //直接将剩余链表放到结果链表之后
        ListNode last = null;
        ListNode result = null;
        ListNode nA = listA;
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
                nB = nB.next;
            }
            if (nA.val >= nB.val) {
                if (result == null) {
                    result = nB;
                } else {
                    last.next = nB;
                }
                last = nB;
                nB = nB.next;
            } else {
                nA = nA.next;
            }
        }

        //有一个链表的节点都取完了
        if (nA != null) {
            last.next = nA;
        } else {
            last.next = nB;
        }
        return result;

    }


    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;//反转后新的头结点,
        ListNode cur = head;//cur代表当前需要反转的节点
        ListNode prev = null;//cur的前驱--》前驱信息
        while (cur != null) {
            ListNode curNext = cur.next;
            if (curNext == null) {
                reverseHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return reverseHead;
    }



    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode result = null;
        ListNode resultLast = null;
        if(p1 == null) return p2;
        if(p2 == null) return p1;


        while (p1 != null && p2 != null) {
            if(p1.val >= p2.val) {
                if(result == null) {
                    result = p2;
                } else {
                    resultLast.next = p2;
                }
                resultLast = p2;
                p2 = p2.next;
            } else {
                if(result == null) {
                    result = p1;
                } else {
                    resultLast.next = p1;
                }
                resultLast = p1;
                p1 = p1.next;

            }
        }
        if(p1 ==null) {
            resultLast.next = p2;
        } else {
            resultLast.next = p1;
        }
        return result;

    }


    public ListNode deleteDuplicate(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
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
                while (p2 != null && p1.val ==p2.val) {
                    p2 = p2.next;
                }
                p1 = p2;
                if(p2 != null) {
                    p2 =p2.next;
                }
            }
        }
        return dummy.next;

    }
}

