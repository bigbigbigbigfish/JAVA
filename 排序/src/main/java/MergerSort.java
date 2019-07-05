import java.util.Arrays;

public class MergerSort {
    public static void main(String[] args) {
        int[] arr = new int[] {3,4,6,7,2,7,2,8,0};

        MergeSott(arr);
        System.out.println(Arrays.toString(arr));
    }
    //归并
    private static void merge(int[] arr,int gap) {
        int[] temArray = new int[arr.length];
        int i =0;//temArray 的下标
        int start1 = 0;
        int end1 =start1 + gap -1;
        int start2 = end1+1;
        int end2 = start2 + gap -1 <= arr.length - 1?
                start2 + gap -1 :arr.length-1;
        //保证有两个归并段
        while (start2 < arr.length) {
            //两个归并段都有数据
            while (start1 <= end1 && start2 <= end2) {
                if(arr[start1] <arr[start2]) {
                    temArray[i++] =arr[start1++];

                } else {
                    temArray[i++] =arr[start2++];

                }
            }
            while (start1 <= end1) {
                temArray[i++] = arr[start1++];
            }
            while (start2 <= end2) {
                temArray[i++] = arr[start2++];

            }
            //证明一次二路归并已经完成
            start1 = end2 +1;
            end1 = start1+gap-1;
            start2 =end1 +1;
            end2 = start2 + gap -1 <= arr.length - 1?
                    start2 + gap -1 :arr.length-1;

        }
        while (start1 <arr.length) {
            temArray[i++] = arr[start1++];
        }
        //拷贝数据到原始数组
        for(int j =0; j<temArray.length; j++) {
            arr[j] =temArray[j];
        }

    }
    private static void MergeSott(int[] arr) {
        for (int i=1; i<arr.length; i++) {
          merge(arr,i);
        }
    }
}
