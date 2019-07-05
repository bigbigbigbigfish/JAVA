package com.cao.day4;

class Node {
    int val;
    Node next = null;

    public Node(int val) {

        this.val = val;
    }
}

public class Test {
    Node Reverse(Node head) {
        Node cur = head;
        Node result = null;


        while (cur != null) {
            Node next = cur.next;
            cur.next = result;
            result = cur;
            cur = next;
        }
        return result;

    }
    Node Merge(Node listA, Node listB) {
        Node p1 = listA;
        Node p2 = listB;
        Node result = null;
        Node last = null;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                if (result == null) {
                    result = p1;
                } else {
                    last.next = p1;
                }

                last = p1;
                p1 = p1.next;
            }
            if (p1.val >= p2.val) {
                if (result == null) {
                    result = p2;
                } else {
                    last.next = p2;
                }

                last = p2;
                p2 = p2.next;
            }

            if (p1 != null) {
                last.next = p1;
            } else {
                last.next = p2;
            }

        }
        return result;

    }


    private int getLength(Node head) {
        int length = 0;
        Node cur = head;

        while (cur != null) {
            length ++;
            cur = cur.next;
        }
        return length;
    }


    // 相交链表
    public Node getInterSerctionNode(Node headA, Node headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        Node longer = headA;
        Node shorter = headB;
        int diff = lenA - lenB;
        if(lenA < lenB) {
            diff = lenB - lenA;
            longer =headB;
            shorter = headA;
        }

        for(int i = 0 ;i < diff ;i++) {
            longer = longer.next;
        }
        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }

        return longer;

    }







    // 环链表
    public Node detectCycle(Node head) {
        if(head == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;
        do{
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        } while (fast != null && fast != slow);
        if(fast == null) {
            return null;
        }
        Node p1 = head;
        Node p2 = slow;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }



    class RNode {
        int val;
        RNode next;
        RNode random;

        public RNode(int val) {
            this.val = val;
        }
    }

    //1 先遍历原链表的每一个节点, 复制新节点, 插到原链表的后边
    //2 在遍历原链表的每一个节点,复制进行新节点random 的设置
    //3 cur.next.random = cur.random.next;
    //4 把一条链表拆分原链表和新链表
    RNode CopyRandomList(RNode head) {
        //遍历原链表的每一个节点,创建新节点  把新节点插入到源节点的后一个
        RNode cur = head;
        while (cur != null) {
            RNode newNode = new RNode(cur.val);
            // 把newNode 插入到源链表的后面
            newNode.next = cur.next;
            cur.next = newNode;
            // 让cur 走向下一个原链表的节点
            cur = cur.next.next;
        }



        cur = head;
        while (cur != null) {
            RNode newNode = cur.next;
            if (cur.random == null) {
                newNode.random = null;
            } else {
                newNode.random = cur.random.next;
            }
            cur = cur.next.next;
        }


        //拆
        cur = head;
        RNode result = head.next;
        while (cur != null) {
            RNode newNode = cur.next;
            cur.next = newNode.next;
            if (newNode.next != null) {
                newNode.next = newNode.next.next;

            }
            cur = cur.next;
        }
        return result;
    }





}

