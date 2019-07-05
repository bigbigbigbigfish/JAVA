package com.cao.day.day2;

public interface IArrayList {
    /***
     *
     *  把item 插入到线性表的前面
     * @param item 要插入的数据
     */
    void pushFront(int item);
    void pushBack(int item);
    void add(int item,int index);
    void popFront(); //删除最后的数据
    void popBack();
    void remove(int index);
}
