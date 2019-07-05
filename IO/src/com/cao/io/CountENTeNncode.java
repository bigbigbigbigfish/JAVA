package com.cao.io;

import java.io.UnsupportedEncodingException;

public class CountENTeNncode {
    public static void main(String[] args) {
        String msg = "呵呵";
        byte[] datas = msg.getBytes();//默认使用的是工程的字符集
        System.out.println(datas.length);

        //编码 其他字符集
        try {
            datas = msg.getBytes("UTF-16LE");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(datas.length);
    }
}
