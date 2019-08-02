package day9;
import java.util.*;

public class tEST {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String str1 = str.split(" ")[0];
            String str2 = str.split(" ")[1];
            int[] arr1 = new int[26];

            int[] arr2 = new int[26];
            for(int i =0 ;i < str1.length(); i++) {
                arr1[str1.charAt(i) - 'A']++;
            }
            for(int i =0; i < str2.length(); i++ ) {
                arr2[str2.charAt(i) - 'A']++;
            }

            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (arr1[i] < arr2[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }
}
