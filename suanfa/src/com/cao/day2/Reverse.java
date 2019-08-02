package com.cao.day2;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(reverseSentence(str));
    }



    public static void reverse(char[] ch, int start, int end) {
        while (start < end) {
            char tmp = ch[start];
            ch[start] = ch[end];
            ch[end] = tmp;
            start++;
            end--;
        }
    }

    public static String reverseSentence(String str) {
        if(str == null) {
            return null;
        }
        char[] ch = str.toCharArray();

        reverse(ch,0,str.length()-1);
        int i =0;
        int j =0;

        while (i <ch.length) {
            if(ch[i] == ' ') {
                i++;
                j++;
            } else if(j == ch.length || ch[j] ==' ') {
                reverse(ch,i,--j);
                i = ++j;
            } else {
                ++j;
            }
        }
        return String.copyValueOf(ch);
    }









}
