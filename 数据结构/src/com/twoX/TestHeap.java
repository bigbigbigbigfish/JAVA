package com.twoX;

public class TestHeap {

    private int[] elem;
    private int usedSize;
    private static final int  DEFAULT_SIZE = 10;

    public TestHeap(){
        this.elem = new int[DEFAULT_SIZE];
        this.usedSize = 0;
    }


    public void createHeap(int[] array) {
        for (int i=0; i<array.length;i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        for (int i=(array.length-1-1)/2; i >= 0; i--) {
            AdjustDown(i,array.length);
        }


    }


    public void AdjustDown(int root, int len) {
        int parent = root;
        int chile = 2*parent+1;
        while (chile < len) {
            if(chile + 1<len &&elem[chile] <elem[chile+1]) {
                ++chile;
            }
            if(elem[chile] >elem[parent]) {
                int tmp = elem[chile];
                elem[chile] = elem[parent];
                elem[parent] = tmp;
                parent = chile;
                chile = 2*parent+1;
            } else {
                break;
            }
        }

    }
    public static void isFull() {

    }


    //初始化建立大根堆
//    public void initHeap(int[] array) {
//        if(isFull) {
//            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
//        }
//
//
//
//    }


    public void AdjustUp(int child, int len) {
        while (child > 0) {
            int parent = (child - 1) / 2;
            if(elem[child] > elem[parent]) {
               int temp =elem[child];
               elem[child] = elem[parent];
               elem[parent] = temp;
               parent = child;
               child = (parent -1) /2;
            } else {
                break;
            }
        }
    }
    public boolean isEmpty() {
        return usedSize == 0;
    }

    public void pushHeap(int item) {


    }


    public int popHeap() {
        if(isEmpty()) {
            throw new UnsupportedOperationException();
        }
        int oldData = elem[0];
        int temp = elem[0];
        elem[0] = elem[usedSize - 1];
        elem[usedSize - 1] = temp;
        usedSize--;
        AdjustDown(0,usedSize);
        return oldData;
    }




    public int getHeapTop() {
       return 0;
    }


    public void HeapSort() {
        int end = usedSize - 1;
        while (end != 0) {
            int tem = elem[0];
            elem[0] = elem[end];
            elem[end] = tem;
            AdjustDown(0,end);
            end--;
        }

    }


    public void show() {
        for (int i=0;i<this.usedSize;i++) {
            System.out.println(i + " ");
        }

    }
}




