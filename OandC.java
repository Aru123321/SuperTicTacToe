
import java.util.Scanner;

public class OandC {
    public static Board board;
    public static Player p1;
    public static Player p2;
    public static Player currPlayer;

    public OandC(int boardSize, Player p1, Player p2) {//this constructor initializes the TicTacToe object. It
        this.board = new Board(6);// takes the board size and the 2 players as the input
        this.p1 = p1;
        this.p2 = p2;
        this.currPlayer = p1;
    }

    public static void play(Scanner s) {// here I will initiate the game loop
        System.out.println("Lets start the game!");// welcoming the players

        while (true) {
            board.dispBoard();// Displaying the current state of the board
            System.out.println("Current turn: " + currPlayer.getName());

            int move = getUserInput(s, "Enter your move (1-" + (board.getSize() * board.getSize()) + "): ");

            if (!makeMove(move)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            if (winRules.OrderandChaosWin(board.getBoard())) {
                board.dispBoard();
                System.out.println("Game Over!");
                OandC oandcInstance = new OandC(move, currPlayer, currPlayer);
                Menu.playAgainOrExit(s, oandcInstance);
            }

            currPlayer = (currPlayer == p1) ? p2 : p1;
        }
    }

    private static boolean makeMove(int move) {
        int size = board.getSize();
        int row = (move - 1) / size;
        int col = (move - 1) % size;

        if (row >= 0 && row < size && col >= 0 && col < size && board.checkEmpty(row, col)) {
            board.setCellValue(row, col, currPlayer.getMarker());
            return true;
        }
        return false;
    }

    private static int getUserInput(Scanner scanner, String message) {
        int input;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 1 && input <= board.getSize() * board.getSize()) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and "
                            + (board.getSize() * board.getSize()) + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
        }
        return input;
    }

    public static void resetGame() {
        board = new Board(board.getSize());
        currPlayer = p1;
    }

}
