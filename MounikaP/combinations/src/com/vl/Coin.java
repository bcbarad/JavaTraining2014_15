package com.vl;
public class Coin {
    public static void main(final String[] args) {
        final int num = 10;
        Coin c = new Coin();
        c.combinations(num);
    }
    final void combinations(final int num) {
        System.out.println("the combinations are:");
        for (int i = 0; i < num / 1; i++) {
            for (int j = 0; j < num / 2; j++) {
                for (int k = 0; k < num / 5; k++) {
                    if ((1 * i + 2 * j + 5 * k) == num) {
                        System.out.println(" 1's :" + i + " , 2's :" + j + " , 5's:" + k);
                    }
                }
            }
        }
    }
}
