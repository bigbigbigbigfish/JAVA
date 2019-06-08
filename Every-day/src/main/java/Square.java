import java.util.Scanner;

public class Square {
    //输入在一行中给出正方形边长N（3<=N<=21）和组成正方形边的某种字符C，间隔一个空格。
    //输出由给定字符C画出的正方形。但是注意到行间距比列间距大，
    //所以为了让结果看上去更像正方形，我们输出的行数实际上是列数的50%（四舍五入取整）。
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String a = in.next();
        if(n>=3 && n<= 21) {
            int col = n/2 + n%2;
            for(int i=0; i<col;i++) {
                for(int j=0 ;j < n; j++) {
                    if( i == 0 || i == col -1) {
                        System.out.print(a);
                    }else if(j == 0 || j == n - 1) {
                        System.out.print(a);
                    }else {
                        System.out.print(" ");
                    }

                }
                System.out.println();
            }

        }

    }
}
