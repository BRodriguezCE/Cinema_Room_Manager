import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String shape = scanner.nextLine();
        double pi = 3.14;

        switch (shape) {
            case "triangle" :
                double side1;
                double side2;
                double side3;
                side1 = scanner.nextDouble();
                side2 = scanner.nextDouble();
                side3 = scanner.nextDouble();

                double sPerimeter = (side1 + side2 + side3) / 2.0;
                double triArea = Math.sqrt(sPerimeter * (sPerimeter - side1) *
                        (sPerimeter - side2) * (sPerimeter - side3));

                System.out.println(triArea);
                break;
            case "rectangle" :
                double rectSide1;
                double rectSide2;
                rectSide1 = scanner.nextDouble();
                rectSide2 = scanner.nextDouble();

                double rectArea = rectSide1 * rectSide2;

                System.out.println(rectArea);
                break;
            case "circle" :
                double radius = scanner.nextDouble();

                double circArea = pi * radius * radius;

                System.out.println(circArea);
                break;
            default :
                System.out.println("Not a supported shape");
                break;
        }
    }
}