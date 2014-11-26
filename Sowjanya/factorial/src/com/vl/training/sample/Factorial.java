package com.vl.training.sample;
import java.util.Scanner;
public final class Factorial {
    private Factorial() {
    }
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter the number ");
        int n = scanner.nextInt();
        int result = evennumbers(n);
        System.out.println("The sum of factorial of" + n);
        System.out.println(" even numbers is " + result);
    }
    public static int evennumbers(final int n) {
        int sum = 1, j = 2;
        for (int i = 1; i < n; i++) {
            sum = sum + factorial(j);
            j = j + 2;
        }
        return sum;
    }
    public static int factorial(final int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}

