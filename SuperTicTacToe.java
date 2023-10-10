import java.util.*;

public class SuperTicTacToe implements BoardGame  {
    private Player p1;
    private Player p2;
    private Player currPlayer;
    private static final Integer ROWS_COLS = 3;

    private List<String> alphabetList = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I");
    private Map<String, int[]> letterPositionMap;
    private TicTacToe overallBoard;

    private TicTacToe[][] superTicTacToe;

    public SuperTicTacToe(int boardSize, Player p1, Player p2) {// this constructor initializes the TicTacToe object. It
                                                                // takes the board size and the 2 players as the input
        this.superTicTacToe = new TicTacToe[boardSize][boardSize];
        this.overallBoard = new TicTacToe(boardSize, p1, p2);

        this.letterPositionMap = new HashMap<>();
        int letterIndex = 0;

        // Initialize super board with new tic tac toe
        for (int i = 0; i < ROWS_COLS; i++) {
            for (int j = 0; j < ROWS_COLS; j++) {
                this.superTicTacToe[i][j] = new TicTacToe(ROWS_COLS, p1, p2);
                this.letterPositionMap.put(alphabetList.get(letterIndex), new int[] { i, j });
                overallBoard.getBoard().getBoard()[i][j].setVal(alphabetList.get(letterIndex));
                letterIndex++;
            }
        }

        this.p1 = p1;
        this.p2 = p2;
        this.currPlayer = p1;
    }

    public void play(Scanner s) {// here I will initiate the game loop
        System.out.println("Game starts!");// welcoming the players

        // TODO Fix while

        while (true) {
            displaySuperTicTacToe();// Displaying the current state of the board
            System.out.println("Current turn: " + currPlayer.getName());
            System.out.println("Overall Board is: ");

            this.overallBoard.getBoard().dispBoard();

            // TODO Put in while loop with win condition of representative board
            System.out.println("Enter letter to select the sub board");
            String letterInput = s.next();
            int[] currentBoardCoords = letterPositionMap.get(letterInput);
            TicTacToe currentTicTacToeBoard = this.superTicTacToe[currentBoardCoords[0]][currentBoardCoords[1]];
            currentTicTacToeBoard.setCurrPlayer(currPlayer);
            System.out.println("Current Board is");
            currentTicTacToeBoard.getBoard().dispBoard();


            int move = currentTicTacToeBoard.getUserInput(s,
            String.format("Place your marker %s: ", currPlayer.getName()));
            currentTicTacToeBoard.makeMove(move);
            currentTicTacToeBoard.getBoard().dispBoard();
             
            if (winRules.isGameFinished(currentTicTacToeBoard.getBoard().getBoard())) {
                overallBoard.getBoard().setCellValue(currentBoardCoords[0], currentBoardCoords[1], " ");
                overallBoard.makeMove(alphabetList.indexOf(letterInput)+1);
            }

            // Check if anyone has won
            if (winRules.isGameFinished(overallBoard.getBoard().getBoard())) {
                displaySuperTicTacToe();
                System.out.println("Game Over");
                break;
            }

            currPlayer = (currPlayer == p1) ? p2 : p1;
        }
    }

    
    public void displaySuperTicTacToe() {
        String borderSym = "+---+---+---+--+--+---+---+---+--+--+---+----------+---+---+---+-------+---+---+---+";
        System.out.println(borderSym);

        for (TicTacToe[] singleSuperTicTacToeRow : this.superTicTacToe) {
            for (int subRow = 0; subRow < ROWS_COLS; subRow++) {
                for (int i = 0; i < ROWS_COLS; i++) {
                    Cell[] singleRow = singleSuperTicTacToeRow[i].getBoard().getBoard()[subRow];

                    for (Cell singleCell : singleRow) {
                        System.out.print("| " + singleCell + " ");
                    }

                    System.out.print("| ");
                    if (i < ROWS_COLS - 1) {
                        System.out.print("+ ");
                    }
                }
                System.out.println();
            }
            System.out.println(borderSym);
        }
    }

    @Override
    public boolean makeMove(int move) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeMove'");
    }

    @Override
    public int getUserInput(Scanner scanner, String message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserInput'");
    }

    @Override
    public void resetGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resetGame'");
    }

}
