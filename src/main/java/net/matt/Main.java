package net.matt;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        char[][] field = new char[5][5];
        initializeField(field);

        Random random = new Random();
        int targetRow = random.nextInt(5);
        int targetCol = random.nextInt(5);

        Scanner scanner = new Scanner(System.in);

        System.out.println("All Set. Get ready to rumble!");

        while (true) {
            int row = getUserInput(scanner, "Enter row (1-5): ");
            int col = getUserInput(scanner, "Enter column (1-5): ");

            if (row - 1 == targetRow && col - 1 == targetCol) {
                field[targetRow][targetCol] = 'x';
                System.out.println("You have won!");
                printField(field);
                break;
            } else {
                field[row - 1][col - 1] = '*';
                printField(field);
            }
        }
    }

    private static void initializeField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = '-';
            }
        }
    }

    private static int getUserInput(Scanner scanner, String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 1 && input <= 5) {
                    return input;
                } else {
                    System.out.println("Input must be between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next();
            }
        }
    }

    private static void printField(char[][] field) {
        System.out.println("0 | 1 | 2 | 3 | 4 | 5 |");
        for (int i = 0; i < field.length; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " | ");
            }
            System.out.println();
        }
    }
}