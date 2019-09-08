package com.twoXX;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr= new int[]{9,8,7,6,5,4,3,2,1};
                //{-3,2,6,-3,-4,9,1,-2,-3,-2,1};
        quitSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static int Big(int[] arr) {
        int sum = 0;
        int tmp;
        for (int i =0,j =1; i< arr.length; i++, j++) {
            tmp = arr[i] + arr[j];
            if(tmp < 0) {
                break;
            }
            sum += arr[i];
        }
        return sum;
    }


    public static void quitSort(int[] arr, int star, int end) {
        if(star < end) {
            int stand = arr[star];
            int low = star;
            int high = end;

            while (low <high) {
                while (low < high && arr[high] >= stand) {
                    high--;
                }
                arr[low] = arr[high];

                while (low < high && arr[low] <= stand) {
                    low ++;
                }
                arr[high] = arr[low];
            }

            arr[low] = stand;
            quitSort(arr,star,low);
            quitSort(arr,low+1,end);
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < arr[i-1]) {
                int temp = arr[i];
                int j;
                for ( j = i-1; j>=0 &&arr[j] > temp;j--) {
                    arr[j+1] = arr[j];
                }
                arr[j+1] = temp;
            }
        }
    }

}
