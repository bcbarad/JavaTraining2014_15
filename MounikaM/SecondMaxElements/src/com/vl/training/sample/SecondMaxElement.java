package com.vl.training.sample;


public class SecondMaxElement {
    public static void main(final String[] args) {
        int[] array = new int[args.length];

        for (int j = 0; j < args.length; j++) {
            array[j] = Integer.parseInt(args[j]);
        }

        SecondMaxElement sm = new SecondMaxElement();
        int secondMax = sm.findSecondMax(array);
        System.out.println("\n second max element in given array is :" + secondMax);
    }

    public int findSecondMax(final int[] array) {
        int second = 0 , first = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i] >= first) {
                if (array[i] == first) {
                    continue;
                } else {
                    second = first;
                }
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

