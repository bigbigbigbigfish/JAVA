package day9;

import java.util.*;

public class Number {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        while (in.hasNextLine()) {
            int a = in.nextInt();
            String str = in.nextLine();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (a >= 65 && a <= 67) {
                    sb.append('2');
                }
                if (a >= 68 && a <= 70) {
                    sb.append('3');
                }
                if (a >= 71 && a <= 73) {
                    sb.append('4');
                }
                if (a >= 74 && a <= 76) {
                    sb.append('5');
                }
                if (a >= 77 && a <= 79) {
                    sb.append('6');
                }
                if (a >= 80 && a <= 83) {
                    sb.append('7');
                }
                if (a >= 84 && a <= 87) {
                    sb.append('8');
                }
                if (a >= 88 && a <= 90) {
                    sb.append('9');
                }
                if (a == 0) {
                    sb.append(0);
                }
                if (a == 45) {
                    sb.append('-');
                }

            }
            String str1 = sb.toString();
            System.out.println(str1);
            str1 = null;
        }
    }
}
