package com.cao.IO;

import java.io.*;
import java.nio.file.Paths;

public class BTest3 {
    public static void main(String[] args) {
        File file = Paths.get("D:","a","ads.txt").toFile();
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            byte[] datas = new byte[1024];
            int len = -1;
            while ((len= in.read(datas))!= -1){
                String str = new String(datas,0,datas.length);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
