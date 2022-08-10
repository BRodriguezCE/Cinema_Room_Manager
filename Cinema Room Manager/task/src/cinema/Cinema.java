package cinema;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Cinema {

    private static String[][] cinema;
    private static int ticketsSold10 = 0;
    private static int ticketsSold8 = 0;

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int col = scanner.nextInt();

        createCinema(row, col);
        boolean exit = false;
        do {
            System.out.println("\n1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int menuOption = scanner.nextInt();

            switch (menuOption) {
                case 1 -> printCinema();
                case 2 -> {
                    buyTicket(row, col);
                    printCinema();
                }
                case 3 -> statistics(row, col);
                case 0 -> exit = true;
            }
        }while(!exit);
    }

    public static void createCinema(int row, int col) {
        System.out.println("\nCinema:");
        //Prints the column numbers
        for (int i = 0; i <= col; i++) {
            if (i == 0) {
                System.out.print(" ");
            } else {
                System.out.print(" " +  i);
            }
        }
        System.out.println();

        cinema = new String[row][col];
        //Assigns each seat 'S'
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++){
                cinema[i][j] = " S";
            }
        }
        //Prints row number and seats in row
        for (int i = 0; i < row; i++) {
            System.out.print(i + 1);
            for(int j = 0; j < col; j++){
                System.out.print(cinema[i][j]);
            }
            System.out.println();
        }

    }

    public static void buyTicket(int row, int col) {
        Scanner scanner = new Scanner(System.in);
        int tickets = row * col;
        int ticketPrice = 0;
        boolean purchased = false;

        do {
            try {
                System.out.println("\nEnter a row number:");
                int rowNum = scanner.nextInt();
                System.out.println("Enter a seat number in that row:");
                int seat = scanner.nextInt();

                if (cinema[rowNum - 1][seat - 1].equals(" S")) {
                    if (tickets <= 60) {
                        ticketPrice = 10;
                        ticketsSold10++;
                    } else {
                        int frontHalf = row/2;

                        if (rowNum <= frontHalf) {
                            ticketPrice = 10;
                            ticketsSold10++;
                        } else {
                            ticketPrice = 8;
                            ticketsSold8++;
                        }
                    }

                    System.out.println("\nTicket price: $" + ticketPrice + "\n");
                    cinema[rowNum - 1][seat - 1] = " B";
                    purchased = true;
                } else if (cinema[rowNum - 1][seat - 1].equals(" B")) {
                    System.out.println("\nThat ticket has already been purchased!");
                }
            } catch (Exception e) {
                System.out.println("Wrong Input!");
            }
        } while (!purchased);
    }

    public static void printCinema() {
        System.out.println("Cinema:");
        //Prints the column numbers
        for (int i = 0; i <= cinema[0].length; i++) {
            if (i == 0) {
                System.out.print(" ");
            } else {
                System.out.print(" " +  i);
            }
        }
        System.out.println();
        //Prints row number and seats in row
        for (int i = 0; i < cinema.length; i++) {
            System.out.print(i + 1);
            for(int j = 0; j < cinema[i].length; j++){
                System.out.print(cinema[i][j]);
            }
            System.out.println();
        }
    }

    public static int totalIncome(int row, int col) {
        int tickets = row * col;
        int income;

        if (tickets <= 60) {
            income = tickets * 10;
        } else {
            int frontHalf = (row/2) * col;
            int backHalf = (row - row/2) * col;

            income = (frontHalf * 10) + (backHalf * 8);
        }

        return income;
    }

    public static void statistics(int row, int col) {
        double totalTickets = row * col;
        int ticketsSold = ticketsSold10 + ticketsSold8;
        int income = (ticketsSold10 * 10) + (ticketsSold8 * 8);
        final DecimalFormat df = new DecimalFormat("0.00");
        double percentSold = (ticketsSold / totalTickets) * 100.00;

        System.out.println("\nNumber of purchased tickets: " + ticketsSold);
        System.out.println("Percentage: " + df.format(percentSold) + "%");
        System.out.println("Current Income: $" + income);
        System.out.println("Total income: $" + totalIncome(row, col));
    }
}