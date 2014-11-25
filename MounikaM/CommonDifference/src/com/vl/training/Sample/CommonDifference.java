package com.vl.training.Sample;
import java.util.Scanner;
import java.lang.Math;

class CommonDifference {
    static boolean checkDifference(final int[] array , final int numOfElements) {
        int count = 0;

        for (int i = 0; i < numOfElements - 1; i++) {        //to store the differences of cosecutive elements in diff array
            int a = array[i + 1] - array[i];
            int b = array[i + 2] - array[i + 1];

            if (Math.abs(a) == Math.abs(b)) {
                count++;
            } else {
                break;
            }
        }
        if (count == numOfElements - 2)  {
            return true;
        } else {
            return false;
        }
    }
    public static void main(final String[] args) {

        int[] array = new int[10];
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no of elements to be entered: ");
        int numOfElements = s.nextInt();

        System.out.println(" enter elements The elements: ");
        for (int i = 0; i < numOfElements; i++) {
            array[i] = s.nextInt();
        }
        boolean result = CommonDifference.checkDifference(array, numOfElements);
        if (result) {
            System.out.println("Difference between any consecutive elements in array are same");
        } else {
            System.out.println("Differenec between consecutive elements in array are not same");
        }
    }
}
