import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int sizeOfArray = scanner.nextInt();
        int[] array = new int[sizeOfArray];

        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = scanner.nextInt();
        }

        int min = array[0];

        for (int i = sizeOfArray - 1; i > 0; i--) {
            if (min > array[i]) {
                min = array[i];
            }
        }

        System.out.println(min);
    }
}