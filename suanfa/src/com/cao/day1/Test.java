package com.cao.day1;



public class Test {
    public static void main(String[] args) {
        System.out.println(Fibonacci(10));
    }


    public static int Fibonacci(int n) {
        int a =1, b=1,c =0;
        if(n <= 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        for(int i = 3; i<= n ; i++) {
            c = a +b;
            b = a;
            a = c;
        }
        return c;
    }





    private static int jumpFloorII(int number) {
        int f1 = 1;
        for (int i=2; i<=number ; ++i) {
            //fi = 2 * (fi-1)
            f1 = 2 * f1;
        }
        return f1;
    }

//    private static int FindGread(Vector<Integer> array) {
//        if(array.isEmpty()) {
//            return 0;
//        }
//
//        Vector<Integer> ret = new Vector<>(array.size(),0);
//        ret.set(0, array.get(0));
//        for(int i= 1 ; i<array.size() ; i++) {
//            ret[i] = Math.max(ret[i-1])
//        }
//    }
}
