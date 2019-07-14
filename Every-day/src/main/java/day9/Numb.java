package day9;

import java.util.Scanner;

public class Numb {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            char[] arr = str.toCharArray();

            int letter[] = new int[91];
            for(int i =0 ;i<str.length(); i++) {
                char c = arr[i];

                if( c >= 'A' && c <= 'Z') {
                    letter[c] ++;
                }
            }

            for(int i =65 ; i<91 ;i++) {
                System.out.println((char) i + ":" +letter[i]);
            }
        }

    }
}
