package com.day11;

public class Test {
    public static void main(String[] args) {
        MySequenceImpl mySequence = new MySequenceImpl();
        for(int i = 0;i < 20;i++){
            mySequence.add(i,i);



        }
        mySequence.display();
        mySequence.display();
    }
}
