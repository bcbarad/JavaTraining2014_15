package com.vl.sf.core;

import java.util.Scanner;

public class FindPrimeAndSameDifference {
    public boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number);

        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
         }
         return true;
    }

    public boolean findSameDifference(int number1, int number2) {
        if ((Math.abs(number1 - number2)) == 2) {
            // System.out.println((Math.abs(number1-number2)));
            boolean number1Status = false;
            number1Status = isPrime(number1);
            if (number1Status) {
                boolean number2Status = false;
                number2Status = isPrime(number2);
                if (number2Status) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        FindPrimeAndSameDifference fd = new FindPrimeAndSameDifference();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The First Number : ");
        int number1 = sc.nextInt();
        System.out.print("Enter The Second Number : ");
        int number2 = sc.nextInt();
        if (fd.findSameDifference(number1, number2)) {
            System.out.println("Both the numbers are prime and difference between is 2 ");
        } else {
            System.out.println("Not same ");
        }
        sc.close();
    }

}
