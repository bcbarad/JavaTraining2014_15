package com.vl.training.sample;
public class Fact {
    private static int count = 1, result = 1;
    public static void main(final String[] args) {
        int n = 0;
        for (int i = 0; i < args.length; i++) {
            n = Integer.parseInt(args[i]);
        }
        Fact f = new Fact();
        int res1 = f.series(n);
        System.out.println("=" + res1);
    }
    final int series(final int l) {
        int j = 0, res = 0, fact=1;
        for (int i = 0; i < l; i++) {
            res = res + fact;
            j = j + 2;
            fact = fact * j * (j-1);
            System.out.print(j + "!");
        }
        return res;
    }
}
