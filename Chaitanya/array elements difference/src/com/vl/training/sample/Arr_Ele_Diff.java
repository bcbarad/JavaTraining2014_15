package com.vl.training.sample;
public class Arr_Ele_Diff {
    public static void main(final String[] args1) {
        int[] args = new int[args1.length];
        Arr_Ele_Diff com = new Arr_Ele_Diff();
        for (int i = 0; i < args1.length; i++) {
            args[i] = Integer.parseInt(args1[i]);
        }
        boolean b = com.compute(args);
        if (!b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    final boolean compute(final int[] args) {
        if (args.length >= 2) {
            int diff = args[0] - args[1];
            for (int i = 1; i < args.length - 1; i++) {
                if (diff == (args[ i ] - args[ i + 1 ]) || diff == (args[ i + 1 ] - args[ i ])) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        } else {
            System.out.println("arguments are less than 2");
            return false;
        }
    }
}
