package com.vl.training.sample;

public class MySample {

    public static void main(final String[] args) {
        System.out.println("Hello, World!");

        // Arg[0] is a number
        if (args.length != 1) {
            System.err.println("Invalid usage. Pass an integer parameter");
            return;
        }

        // Convert the parameter to Integer
        int i;
        try {
            i = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.err.println("Invalid usage. Given parameter is not an integer");
            return;
        }
        MySample sample = new MySample();
        System.out.println("Double value of the given input is: " + sample.multTwo(i));
    }

    public int multTwo(final int i) {
        return 2 * i;
    }
}
