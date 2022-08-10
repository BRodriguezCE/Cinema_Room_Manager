import java.util.Scanner;

public class Main {

    public static int sign(int number) {
        // write your code here
        int check = number;

        if (check < 0) {
            check = -1;
        } else if (check > 0) {
            check = 1;
        } else {
            check = 0;
        }

        return check;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        System.out.println(sign(n));
    }
}