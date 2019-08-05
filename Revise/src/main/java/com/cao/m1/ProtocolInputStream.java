package com.cao.m1;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProtocolInputStream extends FilterInputStream {

    public ProtocolInputStream(InputStream in) {
        super(in);
    }



    public String readLine() throws IOException {
        boolean needRead = true;
        StringBuilder sb = new StringBuilder();
        int b = -1;
        while (true) {
            if (needRead == true) {
                b = in.read();
                if (b == -1) {
                    throw new RuntimeException("不应该读到结尾的");
                }
            } else {
                needRead = true;
            }

            if (b == '\r') {
                int c = in.read();
                if (c == -1) {
                    throw new RuntimeException("不应该读到结尾的");
                }

                if (c == '\n') {
                    break;
                }

                if (c == '\r') {
                    sb.append((char) b);
                    b = c;
                    needRead = false;
                } else {
                    sb.append((char) b);
                    sb.append((char) c);
                }
            } else {
                sb.append((char)b);
            }
        }
        return sb.toString();
    }


    public long readInteger() throws IOException {
        boolean isNegative = false;
        StringBuilder sb = new StringBuilder();
        int b = in.read();
        if(b == -1) {
            throw  new RuntimeException("不该读到结尾");
        }

        if(b =='-') {
            isNegative = true;
        } else {
            sb.append((char) b);

        }
        while (true) {
            b = in.read();
            if (b == -1) {
                throw new RuntimeException("不应该读到结尾的");
            }

            if (b == '\r') {
                int c = in.read();
                if (c == -1) {
                    throw new RuntimeException("不应该读到结尾的");
                }

                if (c == '\n') {
                    break;
                }

                throw new RuntimeException("没有读到\\r\\n");
            } else {
                sb.append((char)b);
            }

        }
        long v= Long.parseLong(sb.toString());
        if(isNegative) {
            v = -v;
        }
        return v;
    }
























}
