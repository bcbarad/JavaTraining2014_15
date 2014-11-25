package com.vl.training.sample;

public class EvenSeriesSum {
    public static void main(final String[] args) {
        if (args.length == 1) {
            int range = Integer.parseInt(args[0]);
            System.out.println("\n enter the range for sum is : " + range);
            EvenSeriesSum es = new EvenSeriesSum();
            int result = es.seriesSum(range);

            System.out.println("\n Sum of the series upto given ranges is:" + result);
        } else {
            System.out.println("\n please enter only one value");
        }
    }
    public int seriesSum(int range) {
        int i = 0;
        int result = 1, fact = 1;

        while (range - 1 != 0) {
            fact = fact * (i + 1) * (i + 2);
            result = result + fact;
            i = i + 2;
            range = range - 1;
        }
        return result;
    }
}

