package com.vl.training.sample;

public class QueensProblem {
    public static void main(String[] arr) {
        if (arr.length == 1) {
            int N = Integer.parseInt(arr[0]);
            Queens queens = new Queens(N);
            queens.placeNQueens(0);
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
    }

    private boolean isSafe(int x2, int y2) {
        for (int i = 0; i < x2; i++) {
<<<<<<< HEAD
            if ( //horizontal condition need not be checked as we are dealing with one -dimensional array
=======
            if ( //horizontal need not be checked as we are using the one-dimesional array the postions does'nt collide
>>>>>>> cd8cc21dae1465fd83f92349001eda98f8ad6b8f
               board[i] == y2 || //vertical
               (i - x2 == board[i] - y2) || (i - x2 == y2 - board[i]) //diagonal
               ) {
                return false;
            }
        }
        return true;
    }

    void placeNQueens(int x) {
        for (int i = 0; i < board.length; i++) {
            if (isSafe(x, i)) {
                board[x] = i;
                if (x == board.length - 1) {
                    printSolution(board);
                }
                else {
                    placeNQueens(x + 1);
                }
            }
        }
    }

    private void printSolution(int[] board) {
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
