package com.cao.day1;


import java.util.Date;

public class Test {
    public static void main(String[] args) {
        /***
         * 1  普通的一个对象 通过java.util实例化的
         */
        Date date = new Date();
       //反向操作,反射
        Class classz = date.getClass();
        System.out.println(classz);
        /***
         *  普通对象实例化
         *  1 new 构造方法
         *  2  反序列化
         *  3 反射
         *  class 对象获取
         *  object.getclass 2 classname.class 3 class.forname("classname")
         */
        try {
            Date date1 = (Date) classz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        // 建议  一般在开发反射的代码中 我们经常使用类的权限定名
        try {
            Class dateClass1 = Class.forName("java.util.Date");
            System.out.println(dateClass1);
        } catch (ClassNotFoundException e) {
            //注意 这里的异常 classNotFoundException
            e.printStackTrace();
        }


    }
}
