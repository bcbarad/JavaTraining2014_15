package com.vl.training.sample;
import java.util.Scanner;
public class SecondMax {
    public static int Max(final int[] array) {
        int maxval = array[0], secondmax = array[1], temp = 0;
        if (maxval < secondmax) {
            temp = secondmax;
            secondmax = maxval;
            maxval = temp;
        }
        for (int i = 0; i < array.length; i++) {
            if (maxval < array[i]) {
                secondmax = maxval;
                maxval = array[i];
            }
            if ((maxval > array[i]) && (array[i] > secondmax)) {
                secondmax = array[i];
            }
        }
        return secondmax;
    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of elements");
        int n = sc.nextInt();
        int[] series = new int[n];
        System.out.println("enter the values");
        for (int i = 0; i < n; i++) {
            series[i] = sc.nextInt();
        }
        int result = SecondMax.Max(series);
        System.out.println("second max is" + result);
    }
}
