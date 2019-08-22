package com.cao;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //冒泡排序
    public static void bubbleSotr(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }


    //插入排序
//    public static void insertSort(int[] arr) {
//       // 遍历所有数字
//        for (int i = 1; i < arr.length; i++) {
//            //如果当前数字小于前一个数组
//            if(arr[i] < arr[i-1]) {
//                //存起当前数字
//                int tmp =arr [i];
//                int j;
//                for ( j = i-1; j >= 0 && arr[j] >tmp ; j--) {
//                    arr[j+1] = arr[j];
//                }
//                arr[j+1] = tmp;
//
//            }
//
//        }
//    }
    //希尔排序
//    public static void shellSort(int[] arr) {
//        for (int d = arr.length / 2; d > 0; d /= 2) {
//            //遍历所有元素
//            for (int i = d; i < arr.length; i++) {
//                for (int j = i - d; j >= 0; j -= d) {
//                    if (arr[j] > arr[j + d]) {
//                        int tmp = arr[j];
//                        arr[j] = arr[j + d];
//                        arr[j + d] = tmp;
//                    }
//                }
//            }
//        }
//
//    }




    //快速排序
//    public static void quitSort(int[] arr, int start, int end) {
//        if (start < end) {
//            int stand = arr[start];
//            int low = start;
//            int high = end;
//            while (low < high) {
//                while (low < high && stand <= arr[high]) {
//                    high--;
//                }
//                arr[low] = arr[high];
//                while (low < high && arr[low] <= stand) {
//                    low++;
//                }
//                arr[high] = arr[low];
//            }
//            arr[low] = stand;
//            quitSort(arr, start, high);
//            quitSort(arr, high + 1, end);
//        }
//    }




    //归并排序

//    public static void merge(int[] arr, int low,int middle,int high) {
//        int[] tmp = new int[high - low +1];
//        //记录数组中需要遍历的下标
//        int i = low;
//        //记录第二个数组中需要遍历的下标
//        int j = middle+1;
//        //用于记录在临时数组中存放的下标
//        int j = middle
//        //遍历两个数组,取出小的数字放入临时的数组中
//        while (i <= middle && j <= high) {
//            if(arr[i] <= arr[j]) {
//
//            }
//        }
//
//
//    }

    //选择排序

//    public static void selectSort(int[] arr) {
//        //遍历所有的数
//        for (int i =0 ; i<arr.length ;i++) {
//            int minIndex = i;
//            //把当前遍历的数和后面所有的数依次进行比较,并记录下最小数的下标
//            for (int j =i+1; j<arr.length; j++) {
//                if(arr[minIndex] >arr[j]) {
//                    minIndex = j;
//                }
//            }
//            //如果最小的数和当前遍历数的下标不一致,说明minIndex的数比当前遍历的数更小
//            if( i!= minIndex) {
//                int temp = arr[i];
//                arr[i] =arr[minIndex];
//                arr[minIndex] = temp;
//            }
//        }
//
//    }

//
//
    public static void insertSort(int[] arr) {
        for (int i =1; i<arr.length ; i++) {
            if(arr[i-1] >arr[i]) {
                int tmp = arr[i];
                int j;
                for (j = i-1 ;j>=0 && arr[j] >tmp; j--) {
                    arr[j+1] = arr[j];
                }
                arr[j+1] = tmp;
            }
        }
    }

//    public static void shellSort(int[] arr) {
//        for (int d =arr.length/2 ; d >0 ; d /= 2) {
//            for (int  i = d; i<arr.length; i++) {
//                for (int j =i-d; j>= 0 ; j-=d){
//                    if(arr[j] > arr[j+d]) {
//                        int tmp = arr[j];
//                        arr[j] = arr[j+d];
//                        arr[j+d] = tmp;
//                    }
//                }
//            }
//
//        }
    //}



   public static void quitSort(int[] arr, int start, int end) {
        if(start < end) {
            int stand = arr[start];
            int low = start;
            int high = end;
            while (low < high) {
                while (low < high && arr[high] > stand) {
                    high--;
                }
                arr[low] = arr[high];

                while (low < high && arr[low] <stand ) {
                    low++;
                }
            }
            arr[low] = stand;
            quitSort(arr,start,low);
            quitSort(arr,low+1,end);
        }
   }

   public static void shellSort(int[] arr) {
       for (int d = arr.length / 2; d > 0; d /= 2) {
           for (int i = d; i < arr.length; i++) {
               for (int j = i - d; j >= 0; j -= d) {
                   if (arr[j] > arr[j + d]) {
                       int tmp = arr[j];
                       arr[j] = arr[j + d];
                       arr[j + d] = tmp;
                   }

               }
           }
       }

   }


   public static void selectSort(int[] arr) {
        for (int i =0 ; i<arr.length-1; i++) {
            int minIndex = i;
            for (int j =i +1 ;j<arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }

            }

            if(i != minIndex) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
   }




}
