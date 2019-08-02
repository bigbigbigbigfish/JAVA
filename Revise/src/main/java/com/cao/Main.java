package com.cao;


import java.io.IOException;
import java.io.InputStream;

public class Main {
        public static void main(String[] args) throws IOException {
                InputStream is = System.in;
                Object o = Protocol.read(is);
        }


}

