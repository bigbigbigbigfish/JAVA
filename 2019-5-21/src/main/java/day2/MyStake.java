package day2;

public class MyStake {
    private int[] elem;
    private int top;
    public MyStake() {
        elem = new int[10];
        int top =0;
    }

//push(x) -- 将元素 x 推入栈中。
//pop() -- 删除栈顶的元素。
//top() -- 获取栈顶元素。
//getMin() -- 检索栈中的最小元素。
    public void push(int x) {
        elem[top++] = x;
    }
    public void pop() {
        top--;
    }
    public int top() {
        return elem[top];
    }
    public int getMin() {
        int min = 0;
        for(int i =1; i<=elem.length; i++) {
             if (elem[i] < min) min = elem[i];

        }
        return min;
    }
}
