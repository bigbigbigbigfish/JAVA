package com.cao.four;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(20);
        set.add(10);
        set.add(31);
        set.add(43);
        //打印输出的升序是怎么来的?
        System.out.println(set);

        Set<String> set1 = new TreeSet<>();
        set1.add("java");
        set1.add("aaa");
        set1.add("bbb");
        System.out.println(set1);


//        Set<Person> people = new TreeSet<>();
//        people.add(new Person("tom",22));
//        people.add(new Person("avicii",19));
//        System.out.println(people);
    }
}
