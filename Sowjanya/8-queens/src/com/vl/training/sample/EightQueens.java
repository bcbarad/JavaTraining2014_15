package com.vl.training.sample;
import java.util.Scanner;
import java.lang.Math;
final class EightQueens {
    private EightQueens() {
    }
    static int[] board;
    static int n;
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of queens you have to place on n/n chessboard");
        n = sc.nextInt();
        board = new int[n];// creating a chess board with n
        EightQueens eq = new EightQueens();
        int row = 0;
        eq.position(row);
    }
    public void position(final int row) {
        for (int column=0;column<board.length;column++) {
             if(issafe(row,column)) {
                board[row]=column;
                if(row==board.length-1) {
                    print();
                } else {
                      position(row+1);
                  }
            }
        }  
    } 
    public boolean issafe(int ithrow,int jthcolumn) {
        for (int i=0;i<ithrow;i++) {
            int diff1 = Math.abs(ithrow- i);
            int diff2 = Math.abs(board[i] - jthcolumn);
            if (board[i] == jthcolumn || diff1 == diff2) {
                return false;
            }
        }
        return true;
    }
    public void print() {
        for(int i=0;i<board.length;i++) {
             System.out.print("("+i+","+board[i]+")"+"   ");
        }
        System.out.println();
    }
}
