package com.vl.training.sample;
import java.lang.Math;
import java.util.Scanner;
public class EightQueens {
    private static int[] board;
    public EightQueens(final int n) {
        board = new int[n];
    }
    public static boolean isSafe(int irow, int jcolumn) {
        for (int j = 0; j < irow; j++) {
            if ((board[j] == jcolumn) || Math.abs(irow - j) == Math.abs(board[j] - jcolumn)) {
                return false;
            }
        }
        return true;
    }
    public static void position(int row) {
        for (int column = 0; column < board.length; column++) {
            board[row] = column;
            if (EightQueens.isSafe(row, column)) {
                if (row == 7) {
                    break;
                } else {
                    position(row + 1);
                }
            }
        }
        if (row == board.length - 1) {
            display();
        }
    }
    public static void display() {
        System.out.println("\n possible combinationa are:");
        for (int i = 0; i < board.length; i++) {
            System.out.println("(" + i + "." + board[i] + ")");
        }
    }
    public static void main(String[] args) {
        int row = 0;
        System.out.println(" enter n X n chess board ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        EightQueens eg = new EightQueens(n);
        EightQueens.position(row);
    }

}








