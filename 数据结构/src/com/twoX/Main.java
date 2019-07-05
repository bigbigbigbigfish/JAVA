package com.twoX;

public class Main {
    private static class Node {
        char value;
        Node left;
        Node right;

        Node(char v) {
            this.value = v;
        }
    }

    private static int count = 0;
    //遍历求节点个数   一般不用
    private static int countByTraversal(Node root) {
        if(root != null) {
            count++;
            countByTraversal(root.left);
            countByTraversal(root.right);
        }
        return count;
    }

    private static int Count(Node root) {
        if(root == null) {
            return 0;
        } else if
                //可写可不写
            (root.left == null && root.right == null) {
            return 1;
        } else {
            return Count(root.left)+Count(root.right) +1;
        }
    }
    //当树是空树, node = null
    private static void preOrderTraversal(Node root) {
        if(root != null) {
            //根 左子树前序遍历  右子树前序遍历
            System.out.println(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
    
    private static void rigOrderTraversal(Node root) {
        if(root != null) {
            rigOrderTraversal(root.left);
            System.out.println(root.value + " ");
            rigOrderTraversal(root.right);
        }
    }
    private static void ordOrderTraversal(Node root) {
        if(root != null) {
            ordOrderTraversal(root.left);
            ordOrderTraversal(root.right);
            System.out.println(root.value + " ");
        }
    }

    private static Node creatTestTree() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        e.right = h;
        return a;
    }

    private static int leafCount(Node root) {
        if(root == null) {
            return 0;
        } else if
            //可写可不写
                (root.left == null && root.right == null) {
            return 1;
        } else {
            return leafCount(root.left)+leafCount(root.right);
        }
    }
    private static int highCount(Node root) {
        if(root == null) {
            return 0;
        } else if(root.left == null && root.right == null) {
            return 1;
        } else {
            return highCount(root.left) > highCount(root.right)
                    ?highCount(root.left) +1:highCount(root.right) +1;
        }

    }
    private static Node find(Node root, char v) {
        if(root== null) {
            return null;
        } else if(root.value == v) {
            return root;
        }else if(find(root.left,v) != null) {
            return find(root.left, v);
        }else if(find(root.right,v) != null) {
            return find(root.right, v);
        }else {
            return null;
        }
    }
    private static Node find2(Node root, char v) {
        if(root == null) {
            return null;
        }
        if(root.value == v) {
            return root;
        }
        Node r =find2(root.left,v);
        if(r != null) {
            return r;
        }
        r = find2(root.right,v);
        if(r != null) {
            return r;
        }
        return null;
    }



    public static void main(String[] args) {
        Node root = creatTestTree();
        preOrderTraversal(root);
        System.out.println();
        rigOrderTraversal(root);
        System.out.println();
        ordOrderTraversal(root);
        System.out.println();
        System.out.println(countByTraversal(root));
        System.out.println(leafCount(root));
        System.out.println(highCount(root));

    }
}
