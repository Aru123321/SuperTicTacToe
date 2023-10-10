import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int gameChoice = Menu.displayMenu(scanner);

        switch (gameChoice) {
            case 1:
                playTicTacToe(scanner);
                break;
            case 2:
                playOrderAndChaos(scanner);
                break;
            case 3:
                playSuperTicTacToe(scanner);
                break;
            case 4:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
        }
    }

    private static void playTicTacToe(Scanner scanner) {
        System.out.println();
        System.out.println("Welcome to Tic Tac Toe!");

        System.out.print("Enter the name for Player 1: ");
        String namePlayer1 = scanner.next();
        System.out.println();
        Player player1 = new Player(scanner, "X", namePlayer1);
        System.out.println();
        System.out.print("Enter the name for Player 2: ");
        String namePlayer2 = scanner.next();
        System.out.println();
        Player player2 = new Player(scanner, "O", namePlayer2);

        int boardSize = getUserInput(scanner, "Enter the size of the board (3 for 3x3, 4 for 4x4, etc.): ");
        System.out.println();
        TicTacToe ticTacToe = new TicTacToe(boardSize, player1, player2);

        ticTacToe.play(scanner);

        scanner.close();
    }

    private static int getUserInput(Scanner scanner, String message) {
        int input;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input > 2) {
                    break;
                } else {
                    System.out.println("Board size must be greater than 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume invalid input
            }
        }
        return input;
    }

    private static void playOrderAndChaos(Scanner scanner) {
        // Implement Order and Chaos game logic here
        System.out.println("Welcome to Order And Chaos!");

        System.out.print("Enter the name for Player 1: ");
        String namePlayer1 = scanner.next();
        Player player1 = new Player(scanner, "X", namePlayer1);

        System.out.print("Enter the name for Player 2: ");
        String namePlayer2 = scanner.next();
        Player player2 = new Player(scanner, "O", namePlayer2);

        OandC orderC = new OandC(6, player1, player2);
        orderC.play(scanner);
    }

    private static void playSuperTicTacToe(Scanner scanner) {
        System.out.println("Welcome to playSuperTicTacToe!");

        System.out.print("Enter the name for Player 1: ");
        String namePlayer1 = scanner.next();
        Player player1 = new Player(scanner, "X", namePlayer1);

        System.out.print("Enter the name for Player 2: ");
        String namePlayer2 = scanner.next();
        Player player2 = new Player(scanner, "O", namePlayer2);

        SuperTicTacToe superTicTacToe = new SuperTicTacToe(3, player1, player2);
        superTicTacToe.play(scanner);
    }
}
