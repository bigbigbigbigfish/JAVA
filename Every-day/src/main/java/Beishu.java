import java.util.Scanner;

public class Beishu {
    public static void main(String[] args) {
        /**
         * 求最小公倍数
         */
        int A;
        int B;
        Scanner in = new Scanner(System.in);
        A = in.nextInt();
        B = in.nextInt();
        for ( int i = 1; i < A * B; i ++) {
            if(A * i % B == 0) {
                System.out.println(A *i);
                break;
            }
        }

    }
}
