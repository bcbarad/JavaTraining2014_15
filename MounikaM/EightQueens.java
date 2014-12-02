package com.vl.training.sample;
import java.util.Scanner;
class EightQueens {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of Chess Board");
        int size = sc.nextInt();
        int[] board = new int[size];
        int row = 0;
        EightQueens q1 = new EightQueens();
        q1.positions(board, row);
    }
    final void dispaly(final int[] board, final int size) {
        for (int i = 0; i < size; i++) {
            System.out.println("postions are(" + i + "," + board[i] + ")");
        }
    }
    final void positions(final int[] board, final int row) {
        EightQueens q1 = new EightQueens();
        if (row == board.length) {
            System.out.println("All Combinations Are");
            q1.dispaly(board, board.length);
        } else {
            for (int column = 0; column < board.length; column++) {
                board[row] = column;
                if (check(board, row)) {
                    positions(board, row + 1);
                }
            }
        }
    }
    final boolean check(final int[] board, final int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row] || Math.abs(board[i] - board[row]) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
