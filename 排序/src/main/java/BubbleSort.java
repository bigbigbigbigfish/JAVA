import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[] {5,7,8,9,10,23,42,53,22};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    /***
     *  比较length -1 轮
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
       for(int i=0 ; i<arr.length -1 ;i++) {
           for(int j =0 ;j<arr.length - 1-i; j++) {
               if(arr[j] >arr[j +1]) {
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j +1] = temp;
               }
           }
       }
    }

}
