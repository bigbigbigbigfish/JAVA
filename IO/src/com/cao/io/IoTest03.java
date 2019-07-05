package com.cao.io;

import java.io.*;

/***  分段读取
 * 创建源
 * 选择流
 * 操作
 * 释放
 */
public class IoTest03 {
    public static void main(String[] args) {
       File src = new File("abc.txt");
       InputStream is = null;
        try {
            is = new FileInputStream(src);
            //分段读取
            byte[] flush  = new byte[1034*10];//缓冲容器
            int len = -1;//接收长度
            while ((len = is.read(flush))!= -1) {
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
