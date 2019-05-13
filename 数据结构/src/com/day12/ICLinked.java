package com.day12;

public interface ICLinked {
    void addFirst(int data);
    void addLast(int data);
    boolean addindex(int index,int data);
    boolean contains(int key);
    int remove(int key);
    void removeAllKey(int key);
    int getLength();
    void display();
    void clear();
}
