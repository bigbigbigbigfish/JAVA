package com.cao.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCopy {
    public static void main(String[] args) {
        try {
            String  src = args[0];
            String  dest = args[1];
            cp(src,dest);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("参数不符合要求: srcFilePath  destFilePath");
        }

    }
    public static void cp(String  srcFilePath, String destFilePath) {
        checkAraument(srcFilePath);
        checkAraument(destFilePath);
        checkFileExist(destFilePath);
        checkFileNotExist(srcFilePath);
        File srcFile = Paths.get(srcFilePath).toFile();
        File desrFile = Paths.get(destFilePath).toFile();
        copy(srcFile,desrFile);
    }
    private static void copy(File srcFile, File destFile) {
        try (FileInputStream ins = new FileInputStream(srcFile);
             FileOutputStream out = new FileOutputStream(destFile)
        ){
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = ins.read(buffer))!= -1) {
                out.write(buffer,0,buffer.length);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private static void checkAraument(String args) {
        if (args == null && args.isEmpty()) {
            System.out.println("参数不能为空");
        }
    }
    private static void checkFileExist(String filePath) {
        Path path = Paths.get(filePath);
        File file= path.toFile();
        if(!(file.exists()&&file.isFile())) {
            throw new IllegalArgumentException(filePath+"NOT exit");
        }
    }
    private static void checkFileNotExist(String filePath) {
        Path path = Paths.get(filePath);
        File file= path.toFile();
        if(!(file.exists())) {
            throw new IllegalArgumentException(filePath+" exit");
        }
    }
}
