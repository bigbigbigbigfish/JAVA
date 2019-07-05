package com.day2;

public class TestSingleton {
    //双重检查
    private static TestSingleton singleton = null;
    private TestSingleton() {

    }
    public static TestSingleton getInstance() {
        if(singleton == null) {
            synchronized (TestSingleton.class) {
                if(singleton == null) {
                    singleton = new TestSingleton();
                }
            }
        }
        return singleton;
    }
}