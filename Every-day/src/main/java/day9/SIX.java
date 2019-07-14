package day9;

import java.util.Scanner;

public class SIX {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int num = -1 ;
        String[] arr = str.split("x",2);
        if(arr[1].equals("0")) {
            num = 0;
        } else if(arr[1].equals("1")) {
            num = 1;
        }else if(arr[1].equals("2")) {
            num = 2;
        }else if(arr[1].equals("3")) {
            num = 3;
        }else if(arr[1].equals("4")) {
            num = 5;
        }else if(arr[1].equals("6")) {
            num = 6;
        }else if(arr[1].equals("7")) {
            num = 7;
        }else if(arr[1].equals("8")) {
            num = 8;
        }else if(arr[1].equals("9")) {
            num = 9;
        }else if(arr[1].equals("A")) {
            num = 10;
        }else if(arr[1].equals("B")) {
            num = 11;
        }else if(arr[1].equals("C")) {
            num = 12;
        }else if(arr[1].equals("D")) {
            num = 13;
        }else if(arr[1].equals("E")) {
            num = 14;
        }else if(arr[1].equals("F")) {
            num = 15;
        }

        System.out.println(num);
    }
}
