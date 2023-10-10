public class winRules {

    public static boolean checkWin(Cell[][] board, String symbol) {
        return isWinner(board, (symbol)) || isDraw(board);
    }

    public static boolean OrderandChaosWin(Cell[][] board) {
        if (isWinner(board, "X")) {
            printBoard(board);
            System.out.println("Player X wins!");
            return true;
        } else if (isWinner(board, "O")) {
            printBoard(board);
            System.out.println("Player O wins!");
            return true;
        } else if (isDraw(board)) {
            printBoard(board);
            System.out.println("Its a draw!");
            return true;
        } else if (isChaosWin(board)) {
            printBoard(board);
            System.out.println("Player Chaos wins!");
            return true;
        }
        return false;
    }

    // New method to check if Chaos wins by filling the board without completing a
    // line of five
    private static boolean isChaosWin(Cell[][] board) {
        int size = board.length;

        // Check if the board is completely filled
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].isEmpty()) {
                    return false;
                }
            }
        }

        // Check if there is no winner for both players
        return !isWinner(board, "X") && !isWinner(board, "O");
    }

    private static boolean isWinner(Cell[][] board, String S) {
        int size = board.length;

        // Check rows and columns
        for (int i = 0; i < size; i++) {
            boolean rowWin = true;
            boolean colWin = true;
            for (int j = 0; j < size; j++) {
                if ((!board[i][j].getVal().equals(S))) {
                    rowWin = false;
                }
                if ((!board[j][i].getVal().equals(S))) {
                    colWin = false;
                }
            }
            return (rowWin || colWin);
        }

        // Check diagonals
        boolean diag1Win = true;
        boolean diag2Win = true;
        for (int i = 0; i < size; i++) {
            if (!board[i][i].getVal().equals(S)) {
                diag1Win = false;
            }
            if (!board[i][size - 1 - i].getVal().equals(S)) {
                diag2Win = false;
            }
        }
        return diag1Win || diag2Win;
    }

    private static boolean isDraw(Cell[][] board) {
        int size = board.length;

        // Check if any cell is empty
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].isEmpty()) {
                    return false;
                }
            }
        }

        // Check if there is a winner for both players
        return !isWinner(board, "X") && !isWinner(board, "O");
    }

    public static boolean isGameFinished(Cell[][] board) {
        if (isWinner(board, "X")) {
            printBoard(board);
            System.out.println("Player X wins!");
            return true;
        } else if (isWinner(board, "O")) {
            printBoard(board);
            System.out.println("Player O wins!");
            return true;
         } 
      
        System.out.println();

        return false;
    }

    private static void printBoard(Cell[][] board) {
        System.out.println("Final Board:");
        for (Cell[] row : board) {
            for (Cell cell : row) {
                System.out.print(cell.getVal() + " ");
            }
            System.out.println();
        }
    }
}
