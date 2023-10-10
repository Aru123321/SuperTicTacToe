
//make changes
import java.util.Scanner;

public class TicTacToe implements BoardGame {
    private Board board;
    private Player p1;
    private Player p2;
    private Player currPlayer;

    public TicTacToe(int boardSize, Player p1, Player p2) {// this constructor initializes the TicTacToe object. It
                                                           // takes the board size and the 2 players as the input
        this.board = new Board(boardSize);
        this.p1 = p1;
        this.p2 = p2;
        this.currPlayer = p1;
    }

    public void play(Scanner s) {// here I will initiate the game loop
        System.out.println("Game starts!");// welcoming the players

        while (true) {
            board.dispBoard();// Displaying the current state of the board
            System.out.println("Current turn: " + currPlayer.getName());
            System.out.println();
            int move = getUserInput(s, "place your marker (1-" + (board.getSize() * board.getSize()) + "): ");

            if (!makeMove(move)) {
                System.out.println("Invalid move. place again.");
                continue;
            }

            if (winRules.isGameFinished(board.getBoard())) {
                board.dispBoard();
                System.out.println("Game Over!");
                Menu.playAgainOrExit(s, this);
            }

            currPlayer = (currPlayer == p1) ? p2 : p1;
        }
    }

    public boolean makeMove(int move) {
        int size = board.getSize();
        int row = (move - 1) / size;
        int col = (move - 1) % size;

        if (row >= 0 && row < size && col >= 0 && col < size && board.checkEmpty(row, col)) {
            board.setCellValue(row, col, currPlayer.getMarker());
            return true;
        }
        return false;
    }

    public int getUserInput(Scanner scanner, String message) {
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
                scanner.next(); // consume invalid input
            }
        }
        return input;
    }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getP1() {
        return this.p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return this.p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public Player getCurrPlayer() {
        return this.currPlayer;
    }

    public void setCurrPlayer(Player currPlayer) {
        this.currPlayer = currPlayer;
    }

    public boolean isGameFinished(Object object) {
        return false;
    }

    public void resetGame() {
        board = new Board(board.getSize());
        currPlayer = p1;
    }

}
