package com.day11;

public interface ILinked {
    void addFirst(int data);
    void addLast(int data);
    boolean addIndex(int index,int data);
    boolean contains(int key);
    int remove(int key);
    void removeAllKey(int key);
    int getLength();
    void display();
    void clear();
}
