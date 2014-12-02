package com.vl.training.sample;
import java.util.Scanner;
public class Queen {
    public static void main(final String[] args) {
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Enter the size of Chess Board");
        //int size = sc.nextInt();
        int size = Integer.parseInt(args[0]);
        int[] q = new int[size];
        int row = 0;
        Queen q1 = new Queen();
        q1.positions(q, row);
    }
    final void dispaly(final int[] q, final int size) {
        //int size = q.length;
        for (int i = 0; i < size; i++) {
            System.out.println("postions are(" + i + "," + q[i] + ")");
        }
    }
    final void positions(final int[] q, final int row) {
        //System.out.println("--------"+row+"------");
        Queen q1 = new Queen();
        int size = q.length;
        if (row == size) {
            System.out.println("All Combinations Are");
            System.out.println("--------------------");
            q1.dispaly(q, size);
            //return q;
        } else {
            //if (column != size) {
            for (int column = 0; column < size; column++) {
                q[row] = column;
                if (check(q, row)) {
                    positions(q, row + 1);
                }
            }
        }
    }
    final boolean check(final int[] q, final int row) {
        for (int i = 0; i < row; i++) {
            if (q[i] == q[row]) {
                return false;
            }
            if (Math.abs(q[i] - q[row]) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }
}
