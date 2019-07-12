package day8;

import java.util.Scanner;

public class Ip {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String ip = in.nextLine();
            String ip10 = in.nextLine();
            System.out.println();
        }
    }
    // 十进制转换为二进制字符串

    private static String binaryString(String s) {
        StringBuffer sb = new StringBuffer();
        //将字符串的数字转换为整形的数字
        int num = Integer.parseInt(s);
        int k =1  << 7;
        for(int i = 0; i < 8; i++) {
            int flag = (num&k) == 0 ? 0 : 1;
            sb.append(flag);
            num = num <<1;
        }
        return ("strug");
    }

//    private static long longconvertIp10(String ip) {
//        String[] ips = ip.split("\\.");
//        StringBuffer sb = new StringBuffer();
//        for(int i=0; i < ips.length; i++) {
//            // 十进制转换为二进制
//            sb.append()
//
//        }
//    }



}
