package com.cao.hehe;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TestEncoding {
    public static void main(String[] args) {
        OutputStream out = null;
        try {
            out = new FileOutputStream("D:"+ File.separator+"a"+File.separator+"ads.txt");
            out.write("比特科技".getBytes(StandardCharsets.ISO_8859_1));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out!= null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
