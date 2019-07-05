package com.cao.day.day9;

import java.util.Arrays;

public class ShileSort {
    public static void main(String[] args) {
        int[] arr = new int[] {3,5,2,6,7,8,3,4,7};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort(int[] arr) {
        for(int d =arr.length/2; d>0;d/= 2) {
         //遍历所有元素
         for(int i=d ;i <arr.length ;i++)   {
                for (int j = i-d; j>=0; j-=d) {
                    if(arr[j] >arr[j+d]) {
                        int temp =arr[j];
                        arr[j] = arr[j+d];
                        arr[j+d] =temp;
                    }
                }
            }
        }
    }
}
