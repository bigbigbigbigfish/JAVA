package com.cao.io;

import java.io.*;

/***
 * 文件字节输出流
 * 1 创建源
 * 2 选择流
 * 3 具体操作
 * 4 释放资源
 */
public class IoTest04 {
    public static void main(String[] args) {
        File src = new File("dextt.txt");
        OutputStream os = null;
        try {
            os = new FileOutputStream(src);
            String msg = "hehehehehe";
            byte[] datas = msg.getBytes();
            try {
                os.write(datas,0,datas.length);
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
