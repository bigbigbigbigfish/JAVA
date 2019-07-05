package com.cao.io;

import java.io.File;

/***
 *  递归 打印子孙级目录和文件名称
 */

public class Test {
    public static void main(String[] args) {
        File src = new File("E:\\JAVA\\IO\\src");
        printName(src,0);
    }
    public static void printName(File src,int deep) {
        //控制层次感
        for (int i= 0 ; i< deep;i++) {
            System.out.print("-");
        }
        //打印名称
        System.out.println(src.getName());
        if(null == src || !src.exists()) {
            return;
        } else if (src.isDirectory()) {
            for(File s:src.listFiles()) {
                printName(s,deep+1);//递归体
            }
        }
    }
}
