package com.cao.exceptions;

public class Test {
}


//懒汉单例
class Singleton1 {
    private static Singleton1 singleton1;
    private Singleton1(){}

    private static Singleton1 getInstance() {
        if(singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }

}
//懒汉式单例双重检查

class Singleton2 {
    private static volatile  Singleton2 singleton2;
    private Singleton2() {}

    public static Singleton2 getInstance() {
        if(singleton2 == null) {
            synchronized (Singleton2.class) {
                singleton2 = new Singleton2();
            }
        }
        return singleton2;
    }
}


class SingletonStaticInner {
    private SingletonStaticInner(){}
    private static class SingletonInner {
        private static SingletonStaticInner singletonStaticInner = new SingletonStaticInner();
    }

    private static SingletonStaticInner getInstance() {
        return SingletonStaticInner.getInstance();

    }
}






//饿汉单例
class Singleton {
    private static final Singleton singleton = new Singleton();
    private Singleton() {

    }

    public static Singleton getInstance() {
        return singleton;
    }
}
































