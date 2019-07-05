package com.cao.hehe;

import java.io.*;
import java.nio.file.Paths;

/***
 * 将字符串中的字符转换为大写
 * 使用内存流
 */
public class TestMemoryStream {
    public static void code1() {
        String msg = "hello world";
        byte[]  datas = msg.getBytes();
        InputStream in = new ByteArrayInputStream(datas);
        OutputStream out = new ByteArrayOutputStream();
        try {
            int len = -1;
            while ((len = in.read()) != -1) {
                len = len - 32;
                out.write(len);
            }
            out.flush();
            byte[] newMessage  = ((ByteArrayOutputStream) out).toByteArray();
            System.out.println(new String(newMessage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /**
         * 1 把data1 复制追加到data  把data2 复制追加到data
         * 2  data1 复制到内存的输出流 data2 复制到内存的输出流 内存的输出流 byte 字节数组流  -  文件输出流
         */
        File file = Paths.get("D:","a","data1.txt").toFile();
        File file1 = Paths.get("D:","a","data2.txt").toFile();
        File file2 = Paths.get("D:","a","data.txt").toFile();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

    }
}
