package com.twoX;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestBinaryTree {
    class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }


    // 前序
    void binaryTreePrevOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val + " ");
        binaryTreePrevOrder(root.left);
        binaryTreePrevOrder(root.right);
    }

    // 中序
    void binaryTreeInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        binaryTreePrevOrder(root.left);
        System.out.println(root.val + " ");
        binaryTreePrevOrder(root.right);
    }

    //后序
    void binaryTreePostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        binaryTreePrevOrder(root.left);
        binaryTreePrevOrder(root.right);
        System.out.println(root.val + " ");
    }

    TreeNode createTestTree(String s) {
        return null;
    }

    //节点个数
    int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return getSize(root.left) + getSize(root.right) + 1;
        }
    }

    //叶子节点的个数
    int getLeafSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else {
            return getLeafSize(root.left) + getLeafSize(root.right);
        }
    }

    // 第 k 层结点个数
    int getKLevelSize(TreeNode root, int k) {
        if (root == null) {
            return 0;
        } else if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);

    }

    public int i = 0;

    //创建一个二叉树
    TreeNode creatTestTree(String s) {
        TreeNode root = null;
        if (s.charAt(i) != '#') {
            root = new TreeNode(s.charAt(i));
            i++;
            root.left = createTestTree(s);
            root.right = createTestTree(s);
        } else {
            i++;
        }
        return root;
    }

    int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return height(root.left) > height(root.right)
                    ? height(root.left) +1 : height(root.right) + 1;
        }
    }

    int binaryTreeComplete(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode top =queue.poll();
            if(top != null) {
                queue.offer(top.left);
                queue.offer(top.right);
            } else {
                break;
            }

        }
        while (queue.peek()!= null) {
            queue.poll();
            return -1;
        }
        return 0;

    }

    // 查找，依次在二叉树的 根、左子树、右子树 中查找 value，如果找到，返回结点，否则返回 null
    TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else if (root.val == val) {
            return root;
        }
        return find(root.left, val) == null ? find(root.left, val) : find(root.right, val);
    }

    void binaryTreePrevOrderNonR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.println(cur.val + " ");
                cur = cur.left;
            }
            top = stack.pop();
            cur = top.right;
        }
        System.out.println();
    }

    void binaryTreeInOrderNonR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root.left;
        TreeNode top = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            System.out.println(stack.peek().val + " ");
            cur = stack.pop().right;
        }
        System.out.println();
    }



















}