import java.util.Scanner;

public interface BoardGame {
    boolean makeMove(int move);//these methods are also used in the implementation of SuperTicTacToe
    void play(Scanner s);
    int getUserInput(Scanner scanner, String message);
    public void resetGame();
}
