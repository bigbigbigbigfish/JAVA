package day9;

import java.util.Arrays;
import java.util.Scanner;

/***
 *  最大的变大于其余边之和;
 */
public class MuBang {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ;i < n; i++) {
            int a = in.nextInt();
            int L = in.nextInt();
            if(a == 1) {
                arr[i] = L;
            } else {
                for(int j = i-1; j >= 0; j--) {
                    if(arr[j] == L) {
                        arr[j] = 0;
                    }
                }
            }
            if(Juje(arr, i + 1)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean Juje(int arr[], int n) {
        boolean a;
        if( n < 3) return false;
        Arrays.sort(arr,0,n);
        int sum = 0;
        for(int j = 0; j<n-1 ; j++) {
            sum = sum +arr[j];
        }

        return sum > arr[arr.length - 1];
    }
}
