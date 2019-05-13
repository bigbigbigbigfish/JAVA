package com.day4;

public class MyStack {

    private int[] array;
    int top;
    MyStack() {
        this.array =new int[100];
        this.top = 0;
    }




    public void push(int v) {
        this.array[this.top++]= v;
    }







    public int pop() {
        /***
         *
         */

        return this.array[--this.top];
    }


    public int peek() {
        /***
         * 查看栈顶元素
         */
        return this.array[this.top];
    }
    public int size() {
        return this.top;
    }



    public boolean isEmpty() {
        return this.top == 0;
    }
}
