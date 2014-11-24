package com.vl.training.sample;
import java.util.Scanner;

public class Mode {
    public static void main(final String[] args) {
        System.out.println("\n enter number of elements want to enter in array:");
        Scanner s = new Scanner(System.in);
        int numOfElements = s.nextInt();
        int[] array = new int[numOfElements];
        System.out.println("\n enter number of elements into array:");
        for (int j = 0; j < numOfElements; j++) {
            array[j] = s.nextInt();
        }
        Mode m = new Mode();
        int result = m.findMode(array);

        System.out.println("Mode of the elements is " + result);
    }
    public int findMode(final int[] array) {
        int previous = 1, count = 1;
        int  result = 0;

        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] == array[i + 1]) {
                count += 1;
            } else {
                count = 1;
            }
            if (previous < count) {
                previous = count;
                result = array[i];
            }
        }
        return result;
    }
}
