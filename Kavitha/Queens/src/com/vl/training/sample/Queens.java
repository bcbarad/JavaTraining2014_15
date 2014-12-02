package com.vl.training.sample;

public class Queens {
    public static void main(final String []args) {
        int[] arr = new int[8];
        int queen = 0;
        Queens.getPosition(queen, arr);
    }
    final boolean isSafe(final int col, final int queen, final int []arr) {
        for (int k = 0; k < queen; k++) {
            int c = Math.abs(arr[k] - col);
            int b = Math.abs(k - queen);
            if (arr[k] == col || c == b) {
                return false;
            }
        }
        return true;
    }
    public static void getPosition(final int queen, final int []arr) {
        boolean f = false;
        if (queen == arr.length) {
            System.out.println("+++++++the possible solutions ++++++");
            Queens.display(queen, arr);
        } else {
            Queens q = new Queens();
            for (int col = 0; col < arr.length; col++) {
                f = q.isSafe(col, queen, arr);
                if (f) {
                    arr[queen] = col;
                    getPosition(queen + 1, arr);
                }
            }
        }
    }
    public static void display(final int queen, final int []arr) {
        for (int k = 0; k < arr.length; k++) {
            System.out.println("position(x,y)" + "(" + k + " " + arr[k] + ")");
            if (k == arr.length - 1) {
                System.out.println("+++++++++++++++++++++++++++++++++");
            }
        }
    }
}

