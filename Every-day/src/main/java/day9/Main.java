package day9;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while(in.hasNextLine()) {
//            String str = in.nextLine();
//            StringBuffer sb = new StringBuffer();
//            for(int i =0; i<str.length(); i++) {
//                if(95==(str.charAt(i))) {
//                    sb.append((char)(str.charAt(i+1)-32));
//                    i++;
//                } else{
//                    sb.append(str.charAt(i));
//                }
//            }
//            System.out.println(sb.toString());
//        }
        String str = in.nextLine();
        PingPang(str);
    }
    //逆置函数
    public static void reverse(char[] arr, int start,int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    public static String reverseSentence(String str) {
        if(str == null) {
            return null;
        }

        char arr[] = str.toCharArray();
        reverse(arr,0,str.length()-1);

        int i=0;
        int j=0;

        while (i <arr.length) {
            if(arr[i] ==' ') {
                i++;
                j++;
            } else if( j == arr.length || arr[j] ==' ') {
                reverse(arr,i,--j);
                i = ++j;
            } else {
                ++j;
            }

        }
        return String.copyValueOf(arr);
    }













    //乒乓球问题  乒乓球框

    public static void PingPang(String str) {
        String str1 = str.split(" ")[0];
        String str2 = str.split(" ")[1];

        int arr1[] = new int[26];
        int arr2[] = new int[26];

        for (int i = 0 ;i < str1.length(); i++) {
            arr1[str1.charAt(i) - 'A']++;
        }

        for (int i = 0 ; i< str2.length() ; i++) {
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