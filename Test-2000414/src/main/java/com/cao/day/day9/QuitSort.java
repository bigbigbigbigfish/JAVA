package com.cao.day.day9;

import java.util.Arrays;

public class QuitSort {
    public static void main(String[] args) {
        int[] arr = new int[] {3,5,2,6,7,8,3,4,7};
        quitSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    public static void quitSort(int[] arr,int start,int end) {
        if (start < end) {
            int atart = arr[start];
            //记录需要排序的下标
            int low = start;
            int high = end;
            //循环找比标准数大的数和比标准数小的数
            while (low < high) {
                while (low < high && start <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && low <= start) {
                    low++;
                }
                arr[high] = arr[low];
            }
            //把标准数赋给所在位置的元素
            arr[low] = start;
            //处理所有小的数字
            //处理所有大的数字
            quitSort(arr, start, low);
            quitSort(arr, low + 1, end);
        }
    }
}
