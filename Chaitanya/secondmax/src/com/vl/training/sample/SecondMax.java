package com.vl.training.sample;
public class SecondMax {
    public static void main(final String[] args) {
        int[] a = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            a[ i ] = Integer.parseInt(args[ i ]);
        }
        SecondMax sm = new SecondMax();
        int i = sm.compute(a);
        if (i == 0) {
            System.out.println("arguments should be two or more");
        }
        else {
            System.out.println("Second Maximum is" + i);
        }
    }
    final int compute(final int[] a) {
        int max = a[0];
        int secondmax = a[0];
        if (a.length > 2) {
            for (int i = 1; i < a.length; i++) {
                if (a[ i ] >= max) {
                    if (a[ i ] != max) {
                        secondmax = max;
                    }
                    max = a[ i ];
                }
                else if (a [ i ] >= secondmax) {
                    secondmax = a[i];
                }
            }
            return secondmax;
        }
        else {
            return 0;
        }
    }
}
