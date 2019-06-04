package com.day2;



public class Main {
    private static class Node {
        char value;
        Node left;
        Node right;


        Node(char v) {
            this.value =v;
        }
    }

    private static void preOrderTraversal(Node root) {
        if(root != null) {
            System.out.print(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
    private static void inOrderTraversal(Node root) {
        if(root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.value + " ");
            inOrderTraversal(root.right);
        }
    }
    private static void postOrderTraversal(Node root) {
        if(root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value + " ");


        }
    }

    private static int count(Node root) {
        if(root == null) {
            return 0;
        } else if(root.left == null && root.right == null){
            return 1;
        }else {
            return count(root.left) +count(root.right);
        }
    }
    private static int height(Node root) {
        /***\
         * 1 空树
         * 2 一个节点 可选
         * 3 其他  max(left,right) +1;
         *
         */
        if(root == null) {
            return  0;
        } else{
            int left = height(root.left);
            int right = height(root.right);
            return (left > right ? left:right) +1;
        }
    }


    private static int kLevel(Node root , int k) {
        if(root == null) {
            return  0;
        } else if(k == 1) {
            return 1;
        } else {
            return kLevel(root.left,k-1) + kLevel(root.right,k-1);
        }
    }
    private static Node find(Node root, char v) {
//        if(root ==null) {
//            return null;
//        } else if(root.value == v) {
//            return root;
//        } else if(find(root.left, v)!= null) {
//            return find(root.left,v);
//        } else if(find(root.right, v)!= null ) {
//
//        }
        if(root.value == v ) {
            return  root;
        }
        Node r = find(root.left,v);
        if(r != null){
            return r;
        }
        r = find(root.right,v) ;
        if(r != null) {
            return r;
        }
        return null;
    }


//    private static Node creatTestTree() {
//        Node a = new Node('A');
//        Node b = new Node('B');
//        Node c = new Node('C');
//        Node d = new Node('D');
//        Node e = new Node('E');
//        Node f = new Node('F');
//        Node g = new Node('G');
//        Node h = new Node('H');
//        a.left = b; a.right = c;
//        b.left = d; b.right = e;
//        c.left = f; c.right = g;
//        e.right =h;
//        return a;
//    }

//    public static void main(String[] args) {
//        Node root = creatTestTree();
//        preOrderTraversal(root);
//        System.out.println();
//    }












}
