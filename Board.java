
public class Board {

    public int size;
    public Cell[][] board; // here I declare a private 2d array of Cell object named cell. This is a game
                           // board

    public Board(int size) {// Constructor of the Board class. It inputs the size of the board to work on
                            // the cells.
        this.size = size;
        this.board = new Cell[size][size];// Initialize the cell with the size taken input
        startBoard();
    }

    private void startBoard() { // Here this method initializes the board by creating a new cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Cell();// creating a new object "Cell".
            }
        }
    }

    public void dispBoard() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                System.out.print("+---");
            }
            System.out.println("+");
            for (int c = 0; c < board[r].length; c++) {
                System.out.print("| " + board[r][c].getVal() + " ");
            }
            System.out.println("|");
        }
        for (int c = 0; c < board[0].length; c++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }

    public boolean checkEmpty(int r, int c) { // Here I check if a particular cell is empty. Here we get true if the
                                              // cell is empty.
        return board[r][c].getVal() == " ";
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setCellValue(int r, int c, String value) {// Now if the cell is empty we set the cell value which we
                                                          // introduced in Cell.java
        board[r][c].setVal(value);// here I provide the row and column value where I need to insert the X,O or
                                  // empty space
    }

    public int getSize() {
        return size;
    }
}

/*
 * 4 things I do in the board class:
 * 1) initialize the board
 * 2) Display the current state of the board(by default set to empty)
 * 3) check if a cell is empty
 * 4) set the value to the given cell
 * 3,4 are doing by referencing the cell.java class
 */