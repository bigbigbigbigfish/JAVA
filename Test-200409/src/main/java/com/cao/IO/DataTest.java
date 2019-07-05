package com.cao.IO;

import java.io.*;

public class DataTest {
    public static void main(String[] args) throws IOException {
     //写出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        byte[] datas = baos.toByteArray();
        //操作
        dos.writeUTF("编码");
        dos.write(18);
        dos.writeBoolean(false);
        dos.writeChar('v');
        //读取
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(datas));

    }
}
