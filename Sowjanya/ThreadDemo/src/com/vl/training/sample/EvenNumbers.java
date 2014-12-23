package com.vl.training.sample;
class EvenNumbers {
    public void display(final int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("even :" + i);
            System.out.println("\t");
            i = i + 1;
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.print("\n");
    }
}
