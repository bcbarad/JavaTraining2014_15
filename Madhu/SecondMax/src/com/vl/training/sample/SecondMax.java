package com.vl.training.sample;
public final class SecondMax {
    private SecondMax() {
    }
    static int findSecMax(final int[] list , final int length) {
        int firstmax , secondmax;
        if (length < 2) {
            secondmax = list[0];
        } else {
            if (list[0] > list[1]) {
                firstmax = list[0];
                secondmax = list[1];
            } else {
                firstmax = list[1];
                secondmax = list [0];
            }
            for (int i = 2; i < length; i++) {
                if (list[i] > firstmax) {
                    secondmax = firstmax;
                    firstmax = list[i];
                } else if (list[i] > secondmax) {
                    secondmax = list[i];
                }
            }
        }
        return secondmax;
    }
    public static void main(final String[] args) {
        int len = args.length;
        int[] list = new int[len];
        for (int i = 0; i < args.length; i++) {
            list[i] = Integer.parseInt(args[i]);
        }
        int secondmax = SecondMax.findSecMax(list , len);
        System.out.println(" the second max element in the list is : " + secondmax);
    }
}
