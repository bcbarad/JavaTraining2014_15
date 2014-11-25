package com.vl.training.findmaximum;

public class FindSecondMax {

    public final int findMax(final int []value) {
        int max = 0, secmax = 0;
        max = value[0];
        secmax = value[0];
        for (int i = 1; i < value.length; i++) {
            if (value[i] > max) {
                secmax = max;
                max = value[i];
            } else {
                if (value[i] > secmax) {
                    secmax = value[i];
                }
            }
        }
        return secmax;
    }

    public static void main(final String[] args) {
        FindSecondMax fsm = new FindSecondMax();
        if (args.length == 4) {
            int[] value = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                value[i] = Integer.parseInt(args[i]);
            }
            int max2 = fsm.findMax(value);
            System.out.println("Second largest element:" + max2);
        } else {
            System.out.println("Please provide a no string");
        }
    }
}

