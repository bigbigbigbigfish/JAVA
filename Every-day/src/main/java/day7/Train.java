package day7;

import java.util.ArrayList;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        //给定一个正整数N代表火车数量, 0<N<10 ,接下来输入火车入站的序列,
        // 一共N辆火车,每辆火车以数字1-9编号,要求以字典序列排序输出火车出站的序列号
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            int[] A = new int[n];
            for(int i=0; i<n ;i++) {
                A[i] = scanner.nextInt();
            }

            int start = 0;
            ArrayList<int[]> result = new ArrayList<>();
            Permutation(A,start,n,result);
            for( int[] out: result) {

            }
        }
    }
}
