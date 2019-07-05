package com.cao.io;

import java.io.File;

/***
 * 统计文件夹的大小
 */
public class DirCount {
    public static void main(String[] args) {
        File src = new File("E:\\JAVA\\IO\\src");
        count(src);
        System.out.println(len);
    }
    private static long len = 0;
    public static void count(File src) {
        //获取大小
        if(null != src && src.exists()) {
            if(src.isFile()) {
                len +=src.length();

            }else {
                for (File s :src.listFiles()) {
                    count(s);
                }
            }
        }
    }

}
