package com.cao.day.day2;


public class MyArrayList implements IArrayList{
    private  int[] array; //用来保存数据的空间
    private int size; //保存有效数据个数

    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList(10);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.pushBack(3);
    }

    MyArrayList(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

//    public void pushFront(int item) { //头插
//        for(int i = this.size; i>= 1 ;i--) {
//            this.array[i] = this.array[i-1];
//        }
//
//    }

    public void pushBack(int item) {
        this.array[this.size] = item;
        this.size++;
    }

    public void add(int item, int index) {
        if(index<0 ||index >this.size)
        for(int i = this.size -1 ; i >= index ; i--) {
            this.array[i+1] = this.array[i];
        }
        for(int i =0; i<this.size -index; i++) {
            this.array[this.size-1] = this.array[this.size-i-1];
        }
        this.array[index] = item;
        this.size++;
    }

    public void pushFront(int item) {
        for(int i = this.size; i>= 1; i--) {
            this.array[i] =this.array[i-1];
            size++;
        }
    }

    public void popFront() {
        ensureCapacity();
        for(int i = 1 ; i<= this.size-1;i++) {
            this.array[i-1] = this.array[i];
        }
        this.array[--this.size] =0;
    }
    //时间复杂度 O(1)
    public void popBack() {
        ensureCapacity();
        if(this.size == 0) {
            throw  new Error();
        }
        this.array[--this.size] = 0;
    }

    public void remove(int index) {
        ensureCapacity();
        for(int i = index ;i<= this.size-2 ;i++) {
            this.array[i] = this.array[i+1];
        }
        //this.size--;
//        for(int i =this.size; i>=index ; i--) {
//            this.array[i-1] = this.array[i];
//        }
       this.array[--this.size] = 0;
    }
    //保证数组容量够用O(n)
    private void ensureCapacity() {
        if(this.size < this.array.length) {
            return;
        }
        int capacity = this.array.length*2;
        int [] newArray = new int[capacity];

        for(int i = 0 ;i<this.size;i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;


    }




















}
