package com.vl.training.sample;
public final class NFactSum {
    private NFactSum() {
    }
    static int  factorial(final int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact = fact * i;
        }
        return fact;
    }
    public static void main(final String[] args) {
        int sum = 0;
        int number = Integer.parseInt(args[0]);
        for (int i = 1; i < (number * 2); i *= 2) {
            sum = sum + NFactSum.factorial(i);
        }
        System.out.println("  sum of the factorials series be: " + sum);
    }
}
