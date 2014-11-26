package com.vl.training.sumoffactorial;

public class SumFactorial {

    public final int findFactorial(final int no) {
        int inc = 0, fact = 1, sum = 0;
        for (int i = 0; i < no; i++) {
            sum = sum + fact;
            inc = inc + 2;
            fact = fact * inc * (inc - 1);
        }
        return sum;
    }

    public static void main(final String []args) {
        int no = Integer.parseInt(args[0]);
        SumFactorial sf = new SumFactorial();
        int result = sf.findFactorial(no);
        System.out.println("Sum of factorial:" + result);
    }
}
