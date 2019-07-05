package com.cao.IO;

import java.io.File;
import java.nio.file.Paths;

/***
 * 递归打印文件目录
 */
public class BTest2 {
    public static void main(String[] args) {
        File file = Paths.get("D:","a").toFile();
        listAllfile(file);

    }
    public static void listAllfile(File file) {
        if(file.isDirectory()) {
            File[] result = file.listFiles();
            if(result != null) {
                for (File s : result) {
                    listAllfile(s);
                }
            }
        } else  {
            System.out.println(file);
        }
    }
}
