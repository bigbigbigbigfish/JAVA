package com.cao.day2;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String str =DeleteChars(s1,s2);
            System.out.println(str);
        }
    }


    public static String DeleteChars(String str1,String str2) {
        if(str1 == null || str2 == null) {
            return null;
        }



        boolean[] hashTable = new boolean[256];
        int len = str2.length();
        int i =0;
        while (i < len) {
            int index = str2.charAt(i);
            hashTable[index] = true;
            i++;
        }
        char[] str1s = str1.toCharArray();
        int k =0;
        int j =0;
        while (k < str1s.length) {
            int index = str1s[k];
            if(!hashTable[index]) {
                str1s[j++] = str1s[k];
            }
            k++;
        }

        str1s = Arrays.copyOf(str1s,j);
        return String.copyValueOf(str1s);





    }













}
