package com.vl.training.sample;

public class FactorialSummation {
    public static void main(String arr[]) {
    int n = Integer.parseInt(arr[0]);
    System.out.println("\b\b = " + factSummation(n));
    }
    public static int factSummation(int n) {
        int sum = 0, j = 0, temp = 1;
        for (int i = 0; i < n; i++){
            sum = sum + temp;
            j += 2;
            temp = temp * j * (j - 1);
            System.out.print(" " + (j - 2) + "! +");
        }
        return sum;
    }
}
