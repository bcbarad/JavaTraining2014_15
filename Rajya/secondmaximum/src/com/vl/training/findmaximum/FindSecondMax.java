package com.vl.training.findmaximum;

public class FindSecondMax {

    public final int findMax(final String[] args) {
        int[] value = new int[args.length];
        int max = 0, secmax = 0;
        for (int i = 0; i < args.length; i++) {
            value[i] = Integer.parseInt(args[i]);
        }
        for (int i = 0; i < args.length; i++) {
            if (i == 0) {
                max = value[i];
                secmax = value[i];
            } else {
                if (value[i] > max) {
                    secmax = max;
                    max = value[i];
                } else {
                    if (value[i] > secmax) {
                        secmax = value[i];
                    }
                }
            }
        }
        return secmax;
    }

    public static void main(final String[] args) {
        FindSecondMax fsm = new FindSecondMax();
        if (args.length == 0) {
            System.out.println("Please provide a no string");
        } else {
            int max2 = fsm.findMax(args);
            System.out.println("Second largest element:" + max2);
        }
    }
}

