package com.twoXX;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }



//    private ArrayList list = new ArrayList();
//    private void prepred(TreeNode root) {
//        if(root != null) {
//            list.add(root.val);
//            prepred(root.left);
//            prepred(root.right);
//
//        }
//    }
//
//    public List<Integer> preorderTraversal(TreeNode root) {
//        list = new ArrayList<>();
//        prepred(root);
//        return list;
//
//    }


    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if(root == null) {
            return list;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }
        return list;
    }


    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        if(p.val != q.val) return false;
        return isSameTree1(p.right,q.right) && isSameTree1(p.left,q.left);
    }




    public boolean check(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return true;
    }

//    public boolean isSameTree2(TreeNode p, TreeNode q) {
//        if(p ==null && q ==null) return true;
//        if(!check(q,p)) return false;
//
//    }


    public static void quitSort(int[] arr,int start,int end) {
        if (start <end) {
            int stand = arr[start];
            int low = start;
            int high = end;

            while (low < high) {
                while (low < high &&stand <=arr[high]) {
                    high--;
                }
                arr[low] = arr[high];

                while (low < high && arr[low] < stand) {
                    low ++;

                }
                arr[high] = arr[low];
            }
            arr[low] = start;
            quitSort(arr,start,low);
            quitSort(arr,low+1,high);

        }
    }


















    public static void merge(int[] arr, int low ,int middle, int high) {
        //用于存储归并后的临时数组
        int[] temp = new int[high - low +1];
        //记录第一个数组中需要遍历的下标
        int i = low;
        // 记录第二个数组中需要遍历的下标
        int j =middle +1;


        //用于记录在临时数组中存放的下标
        int index = 0;

        //遍历两个数组, 取出小的数组放入临时数组中

        while (i <= middle && j <= high) {
            if(arr[i] <= arr[j]) {
                //把小的数据放入临时数组中
                temp[index] = arr[i];
                //让下标向后移一位
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        //处理多余的数据
        while ( j <= high) {
            temp[index] = arr[j];
            j++;
            index++;
        }

        while (i <= middle) {
            temp[index] = arr[i];
            i++;
            index++;
        }

        //把临时数组中的数据重新存入原数组
        for (int k =0; k<temp.length ;k++) {
            arr[k+low] = temp[k];
        }
    }


    public static void MergeSort(int[] arr, int low, int high) {
        int middle= (high + low) /2;
        if(low < high) {
            MergeSort(arr,low,middle);
            MergeSort(arr,middle+1,high);
            merge(arr,low,middle,high);
        }
    }




}
