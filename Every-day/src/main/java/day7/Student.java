package day7;

import java.util.Scanner;

public class Student {
    //统计同成绩学生人数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if(n == 0) {
                return;
            }
            int[] arr = new int[n];
            for(int i =0; i< arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            int t =scanner.nextInt();
            int count = 0;
            for(int i =0; i<arr.length; i++) {
                if(t == arr[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
