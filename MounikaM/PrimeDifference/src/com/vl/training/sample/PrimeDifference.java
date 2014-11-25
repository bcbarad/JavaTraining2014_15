package com.vl.training.sample;

public class PrimeDifference {
    public static void main(final String[] args) {

        if (args.length < 2) {
            System.out.println("\n please enter two values");
        } else {

            int number1 = Integer.parseInt(args[0]);
            int number2 = Integer.parseInt(args[1]);


            PrimeDifference pd = new PrimeDifference();
            boolean result = pd.findPrimeDifference(number1, number2);

            if (result) {
                System.out.println("\n entered numbers are prime and their difference is 2");
            } else {
                System.out.println("\n enetred numbers may or may not prime and their difference may or may not 2");
            }
        }
    }

    public boolean findPrimeDifference(final int number1, final int number2) {
        if (((number1 - number2 == 2) || (number1 - number2 == -2)) && isPrime(number1) && isPrime(number2)) {
            return true;
        }  else {
            return false;
        }
    }
    public boolean isPrime(final int a) {
        int flag = 0;
        for (int i = 2; i < a / 2; i++) {
            if (a % i == 0) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            return false;
        } else {
            return true;
        }
    }
}



