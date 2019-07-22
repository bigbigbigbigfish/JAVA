package day9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Numbb {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        List<Integer> list = new ArrayList<>();
        int up =a > b ? b : a;
        printList(b,up,list);
    }

    private static void printList(int a, int b, List<Integer> list) {
        if( b == 0) {
            System.out.println(list);
        }

        if( a <= 0 || b < 0) {
            return;
        }

        List<Integer> list1 = new ArrayList<>(list);

        printList(b,a-1,list);

        list1.add(a);
        printList(b-a,a-1,list1);
    }
}
