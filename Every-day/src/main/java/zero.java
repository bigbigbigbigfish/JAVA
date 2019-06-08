import java.util.Scanner;

public class zero {
    /***
     *  输入一个正整数n! 末尾有多少个0? 比如n = 10 n! = 3628800,所以答案为2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        int j;
        for(int i=1; i<=n; i++) {
            j =i;
            while (j %5 ==0) {
                count ++;
                j = j/5;
            }
        }
        System.out.println(count);

    }

//    private static int get(int n) {
//        if(n <= 0) {
//            return 0;
//        } else if(n==1) {
//            return 1;
//        } else {
//            return n*get(n-1);
//        }
//    }
}
