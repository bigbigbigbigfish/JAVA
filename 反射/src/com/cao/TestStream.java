package com.cao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
    public static void code1() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"c++","java","php");
        list.forEach(System.out::println);
        System.out.println("-------------------------");
        Stream<String> stream =list.stream();
        System.out.println(stream.count());
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"hehe","haha","heihei");
//        List<String> newlist = new ArrayList<>();
//        for (String s : list) {
//            if (s.contains("haha")) {
//                newlist.add(s);
//            }
//        }
//        System.out.println(newlist);
        List<String> newlist =list.stream().skip(2).limit(1).filter(s-> {return s.contains("ei");}).collect(Collectors.toList());
        System.out.println(newlist);
    }

}

