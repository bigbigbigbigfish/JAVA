package com.cao.test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int arr[] = {1,2,3,5,6,7,4,9,0,6};
        int k = 4;
        kMinValue(arr,4);


    }
    public static int[] kMinValue(int arr[], int k) {
        for (int i=0; i<arr.length; i++) {
            for (int j =0; j<arr.length -i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j +1] = tmp;
                }
            }
        }
        for (int i =0; i<k; i++) {
            System.out.println(arr[i]);
        }
        return arr;


    }
}
