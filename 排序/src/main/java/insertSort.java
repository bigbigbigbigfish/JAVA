import java.util.Arrays;

public class insertSort {
    public static void main(String[] args) {
        int[] arr = new int[] {3,5,2,6,7,8,3,4,7};
        insert(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void insert(int[] arr) {
       //遍历所有的数字
        for(int i =1; i<arr.length; i++) {
            //如果当前数字比前一个数字小
            if(arr[i] < arr[i-1]) {
                //存起当前数字
                int temp = arr[i];
                //遍历当前数字前面所有的数字
                int j;
                for( j=i-1; j>=0 && arr[j] > temp; j--) {
                    //把前一个数字赋给后一个数字
                    arr[j+1] = arr[j];
                }
                //把temp 赋给数组里第J+1个(外层for循环的当前元素  赋给不满足条件的后一个元素)
                arr[j+1] = temp;
           }
       }
    }
}
