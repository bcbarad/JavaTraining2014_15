package com.vl.training.sample;
public final class PrimeCheck {
    private PrimeCheck() {
    }
    static boolean checkPrime(final int num) {
        boolean temp = true;
        for (int i = 2; i <= (num / 2); i++) {
            if ((num % i) == 0) {
                temp = false;
            }
        }
        if (temp) {
            return temp;
        } else {
            return temp;
        }
    }
    public static void main(final String[] args) {
        boolean val1 , val2 , dif;
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        if ((num1 - num2) != 2 && (num2 - num1) != 2) {
           System.out.println(" False ");
        } else {
            val1 = PrimeCheck.checkPrime(num1);
            val2 = PrimeCheck.checkPrime(num2);
            if (val1) {
               if (val2) {
                  System.out.println(" True ");
               } else {
                     System.out.println(" false ");
               }
            } else {
                  System.out.println(" True ");
            }
        }   
    }
}

