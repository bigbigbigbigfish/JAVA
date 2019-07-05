package com.cao.hehe;


import java.util.HashMap;
import java.util.Map;

public class PrintTest {
    public static void main(String[] args) {
        Map<Integer,Integer>  map = new HashMap<>();
        map.put(1,1);
        map.put(1,2);
        System.out.println(map.get(1));
    }
}