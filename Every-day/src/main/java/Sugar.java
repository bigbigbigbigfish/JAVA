import java.util.Scanner;

public class Sugar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int y1 = scanner.nextInt() ;
        int y2 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int y4 = scanner.nextInt();

        int A =(y1 + y3)/2;
        int B =(y3 - y1)/2;
        int C =(y4 - y2)/2;
        if (A - B == y1 && B - C == y2 && A + B == y3 && B + C == y4) {
            System.out.println(A + " " + B + " " + C);
        } else {
            System.out.println("No");
        }
    }
}
