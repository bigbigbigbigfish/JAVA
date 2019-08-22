package com.cao.http;


import java.io.FileInputStream;
import java.io.IOException;

public class CustomerClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //"E:\\httpd\\webapp\\" + name + ".class";
        String filename = "E:\\httpd\\webapp\\" + name +".class";
        byte[] buf = new byte[8192];
        int len;
        try {
            len = new FileInputStream(filename).read(buf);
        } catch (IOException e) {
            throw new ClassNotFoundException("没找到", e);
        }

        return defineClass(name, buf, 0, len);
    }
}