import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        /***
         *  w*h 格子 ,行号0-h-1  列号0-w-1 连个蛋糕的欧几里得距离不能等于二
         */
        int W;
        int H;
        Scanner in = new Scanner(System.in);
        int sum = 0;
        W = in.nextInt();
        H = in.nextInt();
        sum = (W/4)*(H/4) * 4* 2;
        sum = sum +(W %4) * (H/4) * 2;
        sum = sum +(H %4) * (W/4) * 2;
        int temp = (W %4) *(H %4);
        if(temp <= 4) {
            sum = sum+temp;
        } else if( temp == 6) {
            sum =sum +4;
        } else  if( temp == 9) {
            sum =sum +5;
        }
        System.out.println(sum);


    }
}
