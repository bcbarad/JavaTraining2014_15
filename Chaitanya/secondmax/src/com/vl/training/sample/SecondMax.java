package com.vl.training.sample;
public class SecondMax {
    public static void main(final String[] args) {
        int[] a = new int[args.length];
        if (a.length > 2) {
            for (int i = 0; i < args.length; i++) {
                a[ i ] = Integer.parseInt(args[ i ]);
            }
            SecondMax sm = new SecondMax();
            sm.compute(a);
        }
        else {
            System.out.println("Arguments should be more than 2");
        }
    }
    final void compute(final int[] a) {
        int max = a[1];
        int secondmax = a[0];
        for (int i = 0; i < a.length; i++) {
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
        System.out.println("second maximum element is"+secondmax);
    }
}
