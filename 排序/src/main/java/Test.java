import java.util.ArrayList;


public class Test {
    public static void main(String[] args) {
        int[] arr = new int[] {5,7,8,9,10,23,42,53,22};
        find(arr,1);

    }


    public static ArrayList find(int[] arr, int k) {
        if(arr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(k);
        if(k >arr.length) {
           return arrayList;
        }
        for(int i =0; i<k;i++) {
            for (int j= 0;j<k -1-i; j++) {
                if(arr[j] >arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            arrayList.add(arr[i]);
        }
        return arrayList;


    }
}
