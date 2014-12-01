package com.vl.training.sample;
public final class QueenProblem {
    private QueenProblem() {
    }
    static final int SIZE = 8;
    private static int[] board = new int[SIZE];
    public static void main(final String[] args) {
        int row = 0, column = 0;
        boolean endsolution = QueenProblem.checkPosition(row , column);
        if (!endsolution) {                                                //checks no possible place on the row for queen
            row--;
            if (row < 0) { 
               System.out.println("----------------End--------------");
            } else { 
                column = board[row] + 1;
                if (column >= SIZE) {
                    row--;
                    column = board[row] + 1;
                }
                QueenProblem.checkPosition(row , column);
            }
        } 
    }
    public static boolean checkPosition(int row , int column) {
        boolean endsolution = false;
        for (; column < SIZE; column++) {
            if (QueenProblem.isSafe(row  , column)) {         // place  the queen on board if issafe()  be true
                board[row] = column;
                if (row == (SIZE - 1)) {
                    endsolution = true;
                    return endsolution;
                } else {
                    endsolution =checkPosition(row + 1 , 0);       // recursive call will move to check the next position
                }
            }
            if (endsolution) {
               QueenProblem.displayPositions();
               endsolution=false;
               return endsolution;
            }
        }
        return endsolution;
    }
    public static boolean isSafe(int row , int column) {    //returns is the position is safe or not to place the queen
        for (int i = 0; i < row; i++) {
            if (board[i] == column ||(Math.abs(board[i] - column) == Math.abs(i - row)) ) {
                return false;       
            } 
        }
        return true;
    }
    public static void displayPositions() {
        for (int i = 0; i < 8; i++) {
            System.out.print("(" + i + "," + board[i] + ")");
        }
        System.out.print("\n");
    }
}
