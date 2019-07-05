package com.cao.four;

import java.util.HashMap;
import java.util.Map;

public class TestHashmap {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();

        map.put(1,"java");
        map.put(2,"c");
        map.put(3,"js");
        map.put(4,"c++");
        map.put(5,"python");
        map.put(6,"sql");

        System.out.println("map的元素个数(k==v): "+map.size());
        System.out.println("map的key =3 "+map.get(3));
        System.out.println("map是否包含key等于2的值 :" +map.containsKey(2));
    }
}
