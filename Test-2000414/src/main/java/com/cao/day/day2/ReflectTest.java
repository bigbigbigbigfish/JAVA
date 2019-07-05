package com.cao.day.day2;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> cls = Class.forName("java.util.Date") ;
        Object object = cls.newInstance();
        System.out.println(object);

    }


    //1  获取class 对象 三种方式
    /***
     * 1
     */
}

class Iphone {
    public Iphone() {
    }
}

