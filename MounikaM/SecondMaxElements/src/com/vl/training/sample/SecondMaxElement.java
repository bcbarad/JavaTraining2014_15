package com.vl.training.sample;
import java.util.Scanner;

public class SecondMaxElement {
    public static void main(final String[] args) {
        System.out.println("\n enetr number of elemnets want to enter:");
        Scanner s = new Scanner(System.in);
        int numOfElements = s.nextInt();
        int[] array = new int[numOfElements];
        System.out.println("\n enter random number of elements : ");

        for (int j = 0; j < numOfElements; j++) {
            array[j] = s.nextInt();
        }

        SecondMaxElement sm = new SecondMaxElement();
        int secondMax = sm.findSecondMax(array);
        System.out.println("\n second max element in given array is :" + secondMax);
    }

    public int findSecondMax(final int[] array) {
        int second = 0 , first = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i] > first) {
                second = first;
                first = array[i];
            } else {

                if (second < array[i]) {
                    second = array[i];
                }
            }
        }
        return second;
    }
}

