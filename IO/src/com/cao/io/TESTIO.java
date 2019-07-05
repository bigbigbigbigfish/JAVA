package com.cao.io;

import java.io.*;
import java.nio.file.Paths;

public class TESTIO {
    //文件输出追加
    public static void code2() {
        File file = Paths.get("D:","a","abc.txt").toFile();
        OutputStream ous = null;
        try {
            ous = new FileOutputStream(file,true);
            byte[] msg = "java is best ".getBytes();
            ous.write(msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(ous != null) {
                try {
                    ous.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void code1() {
        File src = new File("D:" + File.separator+"a"+File.separator+"src.txt");
        File dest = new File("D:"+File.separator+"a"+File.separator+"dest.txt");
        try {
            InputStream in =  new FileInputStream(src);
            OutputStream ous = new FileOutputStream(dest);
            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len=in.read(buffer)) != -1) {
                // len 真正读取的内容的长度
                ous.write(buffer,0,buffer.length);
            }
            in.close();
            ous.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {

    }
}
