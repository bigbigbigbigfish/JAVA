package com.cao.io.homework;

import java.io.File;
import java.util.Date;

/***
 * D:\a
 * f/d name size last_modified
 */
public class Work {
    public static void main(String[] args) {
        ls("D:"+File.separator+"a");

    }
    public static void print(File f) {
        System.out.println((f.isFile()? "f  " : "d  ") + f.getName()+" " +f.length()+ " " + new Date(f.lastModified()));
    }
    public static void ls(String filePath) {
        File file = new File(filePath);
        if(file.exists()) {
            if(file.isFile()) {
                print(file);
            } else  {
                File[] files = file.listFiles();
                if(files != null) {
                    for(File f :files) {
                        print(f);
                    }
                }
            }
        }
    }
}
