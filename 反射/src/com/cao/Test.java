package com.cao;


public class Test {
    public static void main(String[] args) {
        String value ="emp.name:sss|emp.job:Linux Coder";
        EmpAction empAction = new EmpAction();
        empAction.setValue(value);
    }
}