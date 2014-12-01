package com.vl;
public final class Nqueens {
    private Nqueens() {
    }
    private final int[] board = new int[8];
    public final boolean safePosition(final int row , final int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || (i - row) == (board[i] - col) || (i - row) == (col - board[i])) {
                return false;
            }
        }
       return true;
    }
   public final void placeQueens(int row, int col) {
       final int n = 7;
       for (col = 0; col <= n; col++) {
               if (safePosition(row, col)) {
                    board[row] = col;
               if (row == n) {
                   printQueensPosition(board);
               } else {
                   placeQueens(row + 1, 0);
               }
           }
       }
   }
   public final void placeQueens() {
       placeQueens(0, board.length);
   }
   public final void printQueensPosition(final int board[]) {
       for (int i = 0; i <= board.length; i++) {
           for (int j = 0; j < board.length; j++) {
               if (board[i] == j) {
                   System.out.print("Q is in row " + i + "and col"  +j);
                   System.out.println();
               }
           }
       }
   }
   public static void main(String args[]) {
       Nqueens q = new Nqueens();
       q.placeQueens();
   }
}
