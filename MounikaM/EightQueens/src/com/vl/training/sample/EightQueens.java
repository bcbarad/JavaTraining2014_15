//package com.vl.training.sample;
import java.lang.Math;
import java.util.Scanner;
class EightQueens {
    private static final int SIZE = 4;
    private static int[] board = new int[SIZE];

    public static boolean isSafe(int irow, int jcolumn) {
        for (int j = 0; j < irow; j++) {
            if ((board[j] == jcolumn) || Math.abs(irow - j) == Math.abs(board[j] - jcolumn)) {
                return false;
            }
        }
        return true;
    }
    public static void position(int row, int col) {
        for (int column = col; column < SIZE; column++) {
            if (isSafe(row, column)) {
                board[row] = column;
                if (row == SIZE - 1) {
                    display();
                } else {
                    position(row + 1, 0);
                }
            }
        }
    }
    public static void display() {
        System.out.println("\n possible combinationa are:");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("(" + i + "." + board[i] + ")");
        }
    }
    public static void main(String[] args) {
        int row = 0;
        int col = 0;
        EightQueens eg = new EightQueens();
        position(row,col);
    }

}








