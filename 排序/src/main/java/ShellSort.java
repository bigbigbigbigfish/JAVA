import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[] {3,5,2,6,7,8,3,4,7};
        shell(array);
        System.out.println(Arrays.toString(array));

    }
    private static void shell(int[] array) {
        for(int d =array.length/2; d > 0; d /= 2) {
            for(int i=d; i<array.length ; i++) {
                for(int j =i-d; j >= 0; j-= d) {
                    if(array[j] >array[j+d]) {
                        int temp = array[j];
                        array[j] = array[j+d];
                        array[j+d] = temp;
                    }
                }
            }
        }
    }

    public static void shellSort(int[] array) {
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,i);


        }
    }
    private static void shell(int[] array, int gap){

    }
}
