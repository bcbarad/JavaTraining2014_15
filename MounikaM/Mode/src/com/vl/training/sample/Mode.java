package com.vl.training.sample;


public class Mode {
    public static void main(final String[] args) {
        int[] array = new int[args.length];
        for (int j = 0; j < args.length; j++) {
            array[j] = Integer.parseInt(args[j]);
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
