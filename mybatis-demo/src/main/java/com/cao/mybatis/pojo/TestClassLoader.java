package com.cao.mybatis.pojo;

import java.io.*;

public class TestClassLoader extends ClassLoader{

    private String root;
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classDate =loadClassDate(name);
        if(classDate == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name,classDate,0,classDate.length);
        }
    }


    private byte[]loadClassDate(String className) {
        String fileName = root + File.separatorChar + className.replace('.',File.separatorChar) +".class";

        try {
            InputStream is = new FileInputStream(fileName);
            ByteArrayInputStream baos = new ByteArrayInputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = is.read(buffer)) != -1) {
                baos.write(buffer,0,length);

            }
            return baos.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
