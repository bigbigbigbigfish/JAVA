import java.util.Arrays;

public class QuickSqrt {
    public static void main(String[] args) {
        int[] arr = new int[] {3,4,6,7,2,7,2,8,0};
        QuickSqrt(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void QuickSqrt(int[] arr,int start, int end ) {
        //把数组中的第0个数字作为标准数
        if(start < end) {
            int stard = arr[start];
            // 需要记录排序的下标
            int low = start;
            int high = end;
            //循环找比标准数大的数和比标准数小的数
            while (low < high) {
                //右边的数字比标准数大
                while (low < high && stard <= arr[high]) {
                    high--;
                }
                // 右边的数字比标准数小, 使用右边的数字 替换左边的数
                arr[low] = arr[high];
                //左边的数字比标准数小
                while (low < high && arr[low] <= stard) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = stard;
            QuickSqrt(arr, start, low);
            QuickSqrt(arr, low + 1, end);
        }
    }
}
