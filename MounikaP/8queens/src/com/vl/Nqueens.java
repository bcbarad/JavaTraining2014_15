package com.vl;
import java.util.Scanner;
public class Nqueens {
    final boolean safePosition(final int[] board, final int row, final int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || (i - row) == (board[i] - col) || (i - row) == (col - board[i])) {
                return false;
            }
        }
        return true;
    }
    final void printQueensPosition(final int row, final int[] board) {
        int n = board.length;
        if (row == n) {
            System.out.print("all possible combinations are : ");
            System.out.println();
            placeQueens(board, n);
        } else {
            for (int col = 0; col < n; col++) {
                board[row] = col;
                if (safePosition(board, row, col)) {
                    printQueensPosition(row + 1, board);
                }
            }
        }
    }
    final void placeQueens(final int[] board, final int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("desired position is [ " + i +  ", " + board[i] + "]");
        }
    }
    public static void main(final String[] args) {
        int row = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of chess board");
        int n = sc.nextInt();
        int[] board = new int[n];
        Nqueens q = new Nqueens();
        q.printQueensPosition(row, board);
    }
}
