package com.vl.training.sample;
public class Prime {
    public static void main(final String[] args) {
        int[] k = new int[args.length];
        int num1, num2;
        Prime p = new Prime();
        if (args.length == 2) {
            for (int i = 0; i < args.length; i++) {
                k[i] = Integer.parseInt(args[i]);
            }
            num1 = k[0];
            num2 = k[1];
            boolean b = p.validate(num1, num2);
            if (b) {
                System.out.println("a is prime and b is prime and a-b =2");
            } else {
                System.out.println("Condition false");
            }
        } else {
            System.out.println("arguments should be 2 only");
        }
    }
    final boolean validate(final int p1, final int p2) {
        int count = 0, count1 = 0;
        boolean ret = false;
        Prime p = new Prime();
        if ((p1 - p2) == 2 || (p2 - p1) == 2) {
            ret = p.primecheck(p1);
            if (ret) {
                ret = p.primecheck(p2);
                return ret;
            }
            return ret;
        }
        return ret;
    }
    final boolean primecheck(final int p1) {
        boolean ret = true;
        for (int i = 2; i <= Math.sqrt(p1); i++) {
            if (p1 % i == 0) {
                ret = false;
                return ret;
            }
        }
        return ret;
    }
}

