package com.vl.training.primes;

public class FindCoPrimes {

    public final boolean findPrimes(final String []args) {
        int diff, no1, no2;
        no1 = Integer.parseInt(args[0]);
        no2 = Integer.parseInt(args[1]);
        if (no2 - no1 == 2) {
            boolean r = prime(no1) && prime(no2);
            return r;
        } else {
            return false;
        }
    }

    public final boolean prime(final int no) {
        boolean incre = true;
        for (int i = 2; i <= Math.sqrt(no); i++) {
            if (no % i == 0) {
                incre = false;
            }
        }
        return incre;
    }

    public static void main(final String []args) {
        FindCoPrimes fcp = new FindCoPrimes();
        if (args.length == 0) {
            System.out.println("Provide two parameters");
        } else {
            if (fcp.findPrimes(args)) {
                System.out.println("Given no's are co-primes");
            } else {
                System.out.println("Given no's are not co-primes");
            }
        }
    }
}
