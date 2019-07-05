package day1;


public class MyStack implements IMsatck {

    private int[] elem;
    private int top;


    MyStack(int size) {

        this.elem = new int[size];
    }

    private boolean isFull() {
        return this.top == this.elem.length;
    }
    public boolean empty() {
        return this.top == 0;
    }

    public int peek() {
        if(empty()) {
            throw  new Error();
        }
        return this.elem[this.top];
    }

    public int pop() {
        if(empty()) {
            throw  new Error();
        }
        this.top--;
        return this.elem[this.top];
    }

    public void push(int item) {
        if(isFull()) {
            throw  new Error();
        }

        this.elem[this.top++]  = item;

    }

    public int size() {
        return 0;
    }

}
