package com.vl.training.sample;
import java.util.Scanner;
public final class PrimeTest {
    private PrimeTest() {
    }
    public static boolean prime(final int n) {
        for (int i = 2; i < n / 2; i++) {
            if (n / i == 0) {
                return false;
            }
        }
        return true;
    }
    static boolean result(final int a , final int b) {
        if (((a - b) == 2 || (b - a) == 2) && prime(a) && prime(b)) {
            return true;
        }
        return false;
    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a value");
        int a = sc.nextInt();
        System.out.println("enter b value");
        int b = sc.nextInt();
        // int a=5;
        // int b=3;
        System.out.println("result is" + result(a , b));
    }
}
