package day9;


import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        System.out.println(iConverDateToDay(year,month,day));
    }
    public static int iConverDateToDay(int year, int month, int day) {
        if(month>12 || month <1 || day <1 || day >31) {
            return -1;
        }
        int sum = 0;
        int [] arr = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int [] brr = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
        if(uear(year)) {
            for(int i =0; i<month-1; i++) {
                sum = sum + brr[i];
            }
            sum = sum + day;

        } else{
            for(int i =0; i<month-1; i++) {
                sum = sum + arr[i];
            }
            sum = sum + day;

        }
        return sum;
    }


    public static boolean uear(int year) {
        if(year %400 == 0 || (year%4 == 0 && year%100 != 0)) {
            return true;
        }
        return false;
    }
}