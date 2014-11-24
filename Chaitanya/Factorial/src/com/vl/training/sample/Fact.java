//package com.vl.training.sample;
public class Fact {
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
        int j = 0, res = 0;
        for (int i = 0; i < l; i++) {
            res = res + factorial(j);
            System.out.print(j + "!");
            j = j + 2;
        }
        return res;
    }
    final int factorial(final int k) {
        int result = 1;
        if (k == 0) {
            return 1;
        }
        else {
            for (int temp = k; temp >= 1; temp--) {
                result = result * temp;
            }
        }
        return result;
    }
}
