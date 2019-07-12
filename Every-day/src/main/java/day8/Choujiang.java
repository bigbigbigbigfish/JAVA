package day8;

import java.util.Scanner;

public class Choujiang {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            float result =(count(n)/pro(n)) * 100;
            System.out.println(String.format("%.2f",result)+"%");
        }
    }


    private static float pro(int n) {
        if( n == 0) {
            return 1;
        } else {
            return n * pro(n-1);
        }
    }


    private static float count(int n) {
        if(n == 1) {
            return 0;
        } else if( n == 2) {
            return 1;
        } else {
            return (n -1) *(count(n-1) + count(n-2));
        }
    }
}
