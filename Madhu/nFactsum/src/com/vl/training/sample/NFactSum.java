//package com.vl.training.sample;
public final class NFactSum {
    private NFactSum() {
    }
    static int  factorial(final int num) {
        int sum = 0 , fact = 1;
        for (int i = 0 ; i < (num * 2)  ; ) {
            sum += fact;
            i+=2;
            fact *= (i - 1) * i;
        }
        return sum;
    }
    public static void main(final String[] args) {
        int number = Integer.parseInt(args[0]);
        System.out.println("  sum of the factorials series : " + factorial(number));
    }
}
