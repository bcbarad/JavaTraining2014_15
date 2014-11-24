package com.vl.training.sumoffactorial;

public class SumFactorial {

    public final int findFactorial(final int no) {
        int sum = 0;
        for (int i = 1, j = -1; i <= no; i++, j++) {
            sum = sum + fact(i + j);
        }
        return sum;
    }

    public int fact(int value) {
        int f = 1;
        if (value == 0) {
            return 1;
        }
        while (value >= 1) {
            f = value * f;
            value--;
        }
        return f;
    }
    public static void main(final String []args) {
        int no = Integer.parseInt(args[0]);
        SumFactorial sf = new SumFactorial();
        int result = sf.findFactorial(no);
        System.out.println("Sum of factorial:" + result);
    }
}
