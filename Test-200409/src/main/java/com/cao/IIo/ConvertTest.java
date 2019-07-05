package com.cao.IIo;

import java.io.*;

/***
 *  1 转换流
 */
public class ConvertTest {
    public static void main(String[] args) {
        //操作System.in 和System.out
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            //循环获取键盘输入,输出此内容
            String msg = "";
            while (!msg.endsWith("exit")) {
                msg = reader.readLine(); // 循环读取
                writer.write(msg);//循环写出
                writer.newLine();
                writer.flush();//强制刷新
            }
        }catch (IOException e) {
            System.out.println("操作异常");
        }
    }
}
