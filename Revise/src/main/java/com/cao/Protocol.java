package com.cao;

import java.io.IOException;
import java.io.InputStream;

public class Protocol {
    private static String processSimpleString(InputStream is) throws IOException {
        //"+OK\r\n"

        StringBuilder sb = new StringBuilder();
        while (true) {
            int b = is.read();
            if(b == -1) {
                throw  new RuntimeException("不应该读到结尾");
            }

            if(b == '\r') {
                int c = is.read();
                if(c == -1) {
                    throw  new RuntimeException("不应该读到结尾");
                }
                if(c =='\n') {
                    break;
                }
                else {
                    sb.append((char)b);
                    sb.append((char)c);
                }
            }


        }
        return sb.toString();
    }
    public static Object read(InputStream is) throws IOException {
        int b = is.read();
        if(b == -1) {
            throw new RuntimeException("不应该读到结尾");
        }

        switch (b) {

            case '+':
                return processSimpleString(is);
            case '-':
                return new RuntimeException(processError(is));
            case ':':
                return processIniteger(is);
//
//            case '$':
//                return processBulk
//
//                return
//            case '*':
             default:
                throw new RuntimeException("不识别的异常");
        }
    }

    private static long processIniteger(InputStream is) throws IOException {
        //':-1\r\n'
        StringBuilder sb = new StringBuilder();
        while (true) {
            int b = is.read();
            int val = 0;


        }

    }

    private static String processError(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        //'-WRONGTYPE Operation against a key holding the wrong kind of value'
        while (true) {
            int b = is.read();
            if(b == -1) {
                throw new RuntimeException("不应该读到结尾");
            }


        }
    }
}
