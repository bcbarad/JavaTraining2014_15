package com.vl.training.sample;
public final class PrimeCheck {
    private PrimeCheck() {
    }
    static boolean checkPrime(final int num) {
        int temp = 1;
        for (int i = 2; i <= (num / 2); i++) {
            if ((num % i) == 0) {
                temp = 0;
            }
        }
        if (temp == 0) {
            return false;
        } else {
            return true;
        }
    }
    public static void main(final String[] args) {
        boolean val1 , val2 , dif;
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        val1 = PrimeCheck.checkPrime(num1);
        val2 = PrimeCheck.checkPrime(num2);
        int diff = num1 - num2;
        if (diff < 0) {
            dif = PrimeCheck.checkPrime(-1 * diff);
        } else {
            dif = PrimeCheck.checkPrime(diff);
        }
        if (val1 && val2 && dif) {
            System.out.println(" True ");
        } else {
            System.out.println(" False ");
        }
    }
}

