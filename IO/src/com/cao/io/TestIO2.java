package com.cao.io;

import java.io.*;
import java.nio.file.Paths;
//源文件
//目标文件
//输入流
//输出流(字符流)
//操作
//关闭
public class TestIO2 {
    public static void code1() {
        //源文件
        //目标文件
        //输入流
        //输出流(字符流)
        //操作
        //关闭
        File src = Paths.get("D:","a","www.txt").toFile();
        File dest = Paths.get("D:","a","new.txt").toFile();
        try (Reader reader = new FileReader(src);
             Writer writer = new FileWriter(dest);
        ){
            char[] buffer = new char[1024];
            int len = -1;
            while ((len = reader.read(buffer)) != -1) {
                writer.write(buffer,0,len);
            }
            writer.write("文件结束");
        }catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        // 字节流到字符流 编码
        File src = Paths.get("D:","a","wwww.txt").toFile();
        File dest = Paths.get("D:","a","hehe.txt").toFile();
        // 字符流到字节流 解码
        try ( FileInputStream inputStream = new FileInputStream(src);
              InputStreamReader reader = new InputStreamReader(inputStream);
              FileOutputStream outputStream = new FileOutputStream(dest);
              OutputStreamWriter writer  = new OutputStreamWriter(outputStream);){

            char[] buffer = new char[1024];
            int len = -1;
            while ((len = reader.read(buffer))!= -1) {
                writer.write(buffer,0,buffer.length);
            }
        } catch (Exception ignored) {

        }
    }
}
