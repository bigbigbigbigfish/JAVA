package com.cao.IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;

public class BTest {
    public static void main(String[] args) {
        File file = Paths.get("D:","a","ads.txt").toFile();
        OutputStream out = null;
        try {
            file.createNewFile();
            out = new FileOutputStream(file,true);
            String mag = "电耗子   java is best";
            out.write(mag.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if( out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
