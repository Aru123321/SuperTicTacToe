
//make changes

import java.util.Scanner;

class Menu {
    public static int displayMenu(Scanner scanner) {

        System.out.println("Welcome to the Game Menu!");
        System.out.println("1. Tic Tac Toe");
        System.out.println("2. Order and Chaos");
        System.out.println("3. Super TTT");
        System.out.println("4. Exit");
        System.out.println();

        return getUserChoice(scanner, 1, 4);
    }

    private static int getUserChoice(Scanner scanner, int min, int max) {
        int choice;
        while (true) {
            System.out.print("Enter your choice (" + min + "-" + max + "): ");
            System.out.println();
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume invalid input
            }
        }
        return choice;
    }

    public static void results(int w1, String name1, int w2, String name2) {
        System.out.println();
        System.out.println("Player " + name1 + " has won:" + w1);
        System.out.println("Player " + name2 + " has won:" + w2);
        System.out.println();
    }

    public static void playAgainOrExit(Scanner scanner, TicTacToe ticTacToe) {
        System.out.println("Do you want to play again? (Y/N): ");
        String decision = scanner.next();

        if (decision.equalsIgnoreCase("Y")) {
            ticTacToe.resetGame();
            ticTacToe.play(scanner);
        } else if (decision.equalsIgnoreCase("N")) {
            System.out.println("Exiting the game. Goodbye!");
            System.exit(0); // Terminate the program
        } else {
            System.out.println("Invalid choice. Please enter Y or N.");
            playAgainOrExit(scanner, ticTacToe); // Recursive call to handle invalid input
        }
    }

    public static void playAgainOrExit(Scanner scanner, OandC oandc) {
        System.out.println("Do you want to play again? (Y/N): ");
        String decision = scanner.next();

        if (decision.equalsIgnoreCase("Y")) {
            OandC.resetGame();
            OandC.play(scanner);
        } else if (decision.equalsIgnoreCase("N")) {
            System.out.println("Exiting the game. Goodbye!");
            System.exit(0); // Terminate the program
        } else {
            System.out.println("Invalid choice. Please enter Y or N.");
            playAgainOrExit(scanner, oandc); // Recursive call to handle invalid input
        }
    }

}
