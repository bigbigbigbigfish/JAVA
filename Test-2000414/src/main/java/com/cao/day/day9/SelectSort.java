package com.cao.day.day9;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[] {3,5,2,6,7,8,3,4,7};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int[] arr) {
        for(int i = 0 ;i<arr.length;i++) {
            int minIndex = i;
            //把当前遍历的数和后面所有的数进行比较,并记录下最小数的下标
            for(int j =i+1 ;j<arr.length;j++) {
                //如果后面的数比记录的小
                if (arr[minIndex] > arr[j]) {
                    //记录下最小数的下标
                    minIndex = j;

                }
            }
            if(i !=minIndex ) {
                int temp =arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
