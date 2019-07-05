package com.cao.IO;

import java.io.*;

public class PrintTest {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = System.out;
        ps.println("打印流");
        ps.println(true);


        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")));
        ps.println("打印流");
        ps.println(true);
        ps.flush();
        ps.close();
        //重定向输出端
        System.setOut(ps);
        System.out.println("change");
        //重定向回控制台
        System.out.println(new BufferedOutputStream(new FileOutputStream(FileDescriptor.err)));
    }
}
