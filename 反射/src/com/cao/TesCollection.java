package com.cao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TesCollection {
    public static void main(String[] args) {
        code1();
        code2();
        code3();
        code4();
    }

    public static void code2() {
        List<String> list = Collections.emptyList();
        System.out.println(list.size());
    }
    public static void code3(){
        List<String> list = new ArrayList<>();
       List<String>  list1= Collections.synchronizedList(list);
        System.out.println(list1.getClass().getName());
    }

    public static void code4() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7,8,9,0);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
    public static void code1() {
        List<String > list = new ArrayList<>();
        Collections.addAll(list,"java","c++","php");
        System.out.println(list);
    }
}
