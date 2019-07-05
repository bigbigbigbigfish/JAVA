package com.cao.four;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Test10 {
    public static void main(String[] args) {
        List<Father> list = new ArrayList<>();
        Father p1 = new Father("张三",22);
        Father p2 = new Father("李四",33);
        list.add(p1);
        list.add(p2);

        System.out.println(p1.equals(new Father("张三",22)));
        System.out.println(list.contains(p1));
        for (Father aList : list) {
            System.out.println(aList);
        }
    }
}


class Father {
    private String name;
    private Integer age;

    public Father(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Father father = (Father) o;
        return Objects.equals(name, father.name) &&
                Objects.equals(age, father.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}