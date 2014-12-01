package com.vl.training.sample;

public class QueensProblem {
    public static void main(String[] arr) {
        if (arr.length == 1) {
            int N = Integer.parseInt(arr[0]);
            Queens queens = new Queens(N);
        }
        else {
            System.out.println("Enter exactly one input");
        }
    }
}
class Queens {
    int[] board;
    int count = 1;

    Queens(int N) { // N refers to the no. of Queens
        board = new int[N];
        placeNQueens(0, N);
    }

    boolean isSafe(int x2, int y2) {
        for (int i = 0; i < x2; i++) {
            if ( //horizontal need not be checked as we are using the one-dimesional array the postions does'nt collide
               board[i] == y2 || //vertical
               (i - x2 == board[i] - y2) || (i - x2 == y2 - board[i]) //diagonal
               ) {
                return false;
            }
        }
        return true;
    }

    void placeNQueens(int x , int N) {
        for (int i = 0; i < N; i++) {
            if (isSafe(x, i)) {
                board[x] = i;
                if (x == N - 1) {
                    printSolution(board);
                }
                else {
                    placeNQueens(x + 1, N);
                }
            }
        }
    }

    void printSolution(int[] board) {
        System.out.println("Solution :" + count++);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                }
                else {
                    System.out.print("* ");
                }

            }
            System.out.println();
        }
        System.out.println();
    }
}
