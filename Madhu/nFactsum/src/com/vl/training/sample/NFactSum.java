package com.vl.training.sample;
public final class NFactSum {
    private NFactSum() {
    }
    static int  factorial(final int num , final int prevfact) {
        int fact1 = prevfact , i = num - 1;
        if (i == 0) {
               i = 1;
            }
        for ( ; i <=  num; i++ ) {
           fact1 = fact1 * i;
        }
        return fact1;
    }
    public static void main(final String[] args) {
        int sum = 0 , fact = 1;
        int number = Integer.parseInt(args[0]);
        int num = number * 2;
        for (int i = 1 , j = 1; i < num; i=j*2,j++) {
            fact=NFactSum.factorial(i,fact);
            sum = sum + fact;
        }
        System.out.println("  sum of the factorials series : " + sum);
    }
}
