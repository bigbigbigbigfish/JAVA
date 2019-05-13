package com.day11;

import java.util.Arrays;

public class MySequenceImpl implements ISequence {

    private Object[] elem;
    private int useSize;
    private static final int DEFAULT_SIZE =10;

    public MySequenceImpl() {
        this.elem = new Object[DEFAULT_SIZE];
        this.useSize = useSize;
    }

    private boolean isFull() {
        return this.useSize == this.elem.length;

    }

    private boolean isEmpty(){
        return this.useSize ==0;
    }

    @Override
    public boolean add(int pos, Object data) {
        //1 psoe 位置的合法性进行判断
        //2 判断是否已满
       if(pos <0 || pos > this.useSize) {
           return false;
       }
       if(isFull()) {
           this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
       }
       for(int i = this.useSize -1; i>= pos;i--) {
           this.elem[i] = this.elem[i+1];
       }
       this.elem[pos] = data;
       this.useSize ++;
       return true;
    }

    @Override
    public int search(Object key) {
        if (isEmpty()) {
            return -1;
        }
        for(int i =0; i<this.useSize; i++) {
            if (this.elem[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object key) {
        if(isEmpty()){
            return false;
        }
        return false;
    }

    @Override
    public Object getPos(int pos) {
        if(pos <0 ||pos >this.useSize) {
            return null;
        }
        return this.elem[pos];

    }

    @Override
    public Object remove(Object key) {
        int index = search(key);
        if(index == -1) {
            return null;
        }
        Object data = this.elem[index];
        int i;
        for(i=index+1;i>this.useSize-1;i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.useSize--;
        this.elem[i+1] = null;
        return data;
    }

    @Override
    public int size() {
        return this.useSize;
    }

    @Override
    public void display() {
        for(int i =0; i<this.useSize;i++) {
            System.out.print(elem[i] +" ");
        }
        System.out.println();
    }

    @Override
    public void clear() {
        for(int i = 0; i < this.useSize; i++) {
            this.elem[i] = null;
        }
    }
}
