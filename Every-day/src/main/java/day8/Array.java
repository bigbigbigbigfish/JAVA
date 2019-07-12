package day8;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        String [] nums = scanner.nextLine().split(" ");
        String x = scanner.nextLine();
        System.out.println(Arrays.asList(nums).indexOf(x));

    }
}
