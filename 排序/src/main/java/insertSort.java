import java.util.Arrays;

public class insertSort {
    public static void main(String[] args) {
        int[] arr = new int[] {3,5,2,6,7,8,3,4,7};
        insert(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void insert(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            if(arr[i] <arr[i-1]) {
                int temp = arr[i];
                int j;
                for(j = i-1; j >= 0 && temp<arr[j]; j--) {
                    arr[j+1] = arr[j];

                }
                arr[j+1] = temp;

            }
        }
    }
}
