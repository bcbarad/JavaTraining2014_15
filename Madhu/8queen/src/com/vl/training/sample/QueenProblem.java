package com.vl.training.sample;
public final class QueenProblem {
    private QueenProblem() {
    }
    static final int SIZE = 8;
    private static int[] board = new int[SIZE];
    private static int row = 0 , column = 0;
    public static void main(final String[] args) {
        boolean temp = QueenProblem.checkPosition(row , column);
        if (temp) {
            row--;
            column = board[row] + 1;
            if (column >= SIZE) {
                row--;
                column = board[row] + 1;
            }
            QueenProblem.checkPosition(row , column);
        }
        QueenProblem.displayPositions();
    }
    public static boolean checkPosition(int row , int column) {
        boolean temp = true;
        for (; column < SIZE; column++) {
            if (QueenProblem.isSafe(row  , column)) {         // place  the queen on board if issafe()  be true
                board[row] = column;
                if (row == (SIZE - 1)) {
                    temp = false;
                    return temp;
                } else {
                    temp = checkPosition(row + 1 , 0);       // recursive call will move to check the next position
                }
            }
            if (!temp) {
                return temp;
            }
        }
        return temp;
    }
    public static boolean isSafe(int row , int column) {    //returns is the position is safe or not to place the queen
        for (int i = 0; i < row; i++) {
            if (board[i] == column) {
                return false;
            }  else if (Math.abs(board[i] - column) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
    public static void displayPositions() {
        for (int i = 0; i < 8; i++) {
            System.out.println("(" + i + "," + board[i] + ")");
        }
    }
}
