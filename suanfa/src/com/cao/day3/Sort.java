package com.cao.day3;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int [] bbb = new int[] {1,2,32,2,1,42,51,2};
        System.out.println(Arrays.toString(bubbleSort(bbb)));
        System.out.println(Arrays.toString(insertSort(bbb)));
    }
    public static int[] bubbleSort(int [] array) {
        for (int i =0; i<array.length - 1; i++) {
            for (int j =0;j<array.length - i -1; j++) {
                if(array[j] >array[j +1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }


    //直接插入排序

    public static int[] insertSort(int [] array) {

        for (int i =1; i<array.length; i++) {
            if(array[i] <array[i-1]) {
                int tmp = array[i];
                int j;
                for (j = i-1; j >= 0 &&array[j] >tmp; j--) {
                    array[j+1] = array[j];
                }
            }
        }
        return array;
    }
}
