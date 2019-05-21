import java.util.Scanner;

public class Water {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num != 0) {
                System.out.println(Drink(num));
            }
        }
    }

    private static int Drink(int n) {
        if( n == 2) {
            return 1;
        }
        if( n > 2) {
            return n/3 +Drink(n/3 + n % 3);
        }
        return 0;

    }
}
