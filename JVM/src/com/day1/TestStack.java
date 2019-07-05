package com.day1;

public class TestStack {
    private static TestStack testStack = null;




    public void alive() {
        if(testStack != null) {
            System.out.println(testStack +" 还活着");
        } else {
            System.out.println("死了");
        }
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize方法 被jvm执行");
        testStack = this;
    }
}
