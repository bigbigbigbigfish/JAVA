package com.cao.day.day9;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[] {3,5,2,6,7,8,3,4,7};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }



    public static void insertSort(int[] arr) {
        for(int i= 1 ;i<arr.length;i++) {
            if(arr[i] <arr[i-1]) {
                int temp = arr[i];
                int j;
                for( j = i-1;j >= 0 && temp<arr[j];j--) {
                    arr[j+1] =arr[j];
                }
                //把临时变量(外层for循环当前的元素) 赋给不满足条件的后一个数
                arr[j+1] = temp;
            }
        }

    }
}
