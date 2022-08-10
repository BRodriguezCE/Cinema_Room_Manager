import java.util.Scanner;

class MultipleFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        System.out.println(f(x));
    }

    public static double f(double x) {
        //call your implemented methods here.
        return x <= 0 ? f1(x) : x >= 1 ? f3(x) : f2(x);
    }

    //implement your methods here
    public static double f1(double x) {
        double square = x * x;
        return square + 1;
    }

    public static double f2(double x) {
        double square = x * x;
        return 1 / square;
    }

    public static double f3(double x) {
        double square = x * x;
        return square - 1;
    }
}