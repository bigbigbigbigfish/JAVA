package com.cao.io;

import java.io.*;

public class IoTest01 {
    public static void main(String[] args) {
    //1 创建源
        File src = new File("abc.txt");
        //选择流
        try {
            InputStream is = new FileInputStream(src);
            //3 读取
            int data1 = is.read();
            int data2 = is.read();
            int data3 = is.read();
            System.out.println((char)data1);
            System.out.println((char)data2);
            System.out.println((char)data3);
            //4 释放资源
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
