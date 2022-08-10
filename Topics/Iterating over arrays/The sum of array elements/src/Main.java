import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int sizeOfArray = scanner.nextInt();
        int[] arrayElements = new int[sizeOfArray];
        int sum = 0;

        for (int i = 0; i < sizeOfArray; i++) {
            arrayElements[i] = scanner.nextInt();
        }

        for (int num : arrayElements) {
            sum += num;
        }

        System.out.println(sum);
    }
}