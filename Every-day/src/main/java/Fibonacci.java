import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {
    /***
     * 给一个N 变成一个Fibonacci数, 每一步你可以把当前数字x变为x-1或者x+1 现在给你一个数N 求最少需要多少步可以变为Fibonacci数
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();



    }
    public static int Fibonaci(int n) {
        if(n == 0) return 0;
        if( 0 < n && n <= 2) return 1;
        else {
            return Fibonaci(n-1) +Fibonaci(n-2);
        }
    }

}
