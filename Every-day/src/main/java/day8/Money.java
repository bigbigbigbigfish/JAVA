package day8;

public class Money {
    /***
     *
     *
     */
    public static void main(String[] args) {
        long n = 0;
        long m = 0;
        for(int i= 1; i<=30 ;i++) {
            n += 10;
            m = m +(long) Math.pow(2,i-1);
        }

        System.out.println(n +"万元" + " " + m + "分");
    }
}
