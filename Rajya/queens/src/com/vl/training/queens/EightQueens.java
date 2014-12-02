package com.vl.training.queens;

public class EightQueens {

    private int[] queenPosition = new int[8];

    final boolean isSafe(final int position, final int i) {
        for (int j = 0; j < position; j++) {
            //finding difference between columns and diagonals
            int diff1 = Math.abs(position - j);
            int diff2 = Math.abs(queenPosition[j] - i);
            if (queenPosition[j] == i || diff1 == diff2) {
                return false;
            }
        }
        return true;
    }

    final void findQueenPosition(final int position) {
        for (int i = 0; i < queenPosition.length; i++) {
            if (isSafe(position, i)) {
                queenPosition[position] = i;
                if (position == 7) {
                    printSolution();
                } else {
                    findQueenPosition(position + 1);
                }
            }
        }
    }

    final void printSolution() {
        for (int i = 0; i < queenPosition.length; i++) {
            System.out.print("(" + i + "," + queenPosition[i] + ")");
        }
        System.out.println();
    }

    public static void main(final String []args) {
        EightQueens q = new EightQueens();
        int position = 0;
        q.findQueenPosition(position);
    }
}
