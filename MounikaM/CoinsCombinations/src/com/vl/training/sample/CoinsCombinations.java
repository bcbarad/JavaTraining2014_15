package com.vl.training.sample;


public class CoinsCombinations {
    public static void main(final String[] args) {
        int totalMoney = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int m = Integer.parseInt(args[2]);
        int p = Integer.parseInt(args[3]);
        CoinsCombinations c = new CoinsCombinations();
        System.out.println("\nall compinations of coins to get sum = " + totalMoney);
        c.singleCombination(n, totalMoney);
        c.singleCombination(m, totalMoney);
        c.singleCombination(p, totalMoney);
        c.combinations(n, m, totalMoney);
        c.combinations(m, p, totalMoney);
        c.combinations(n, p, totalMoney);
        c.triceCombinations(n, m, p, totalMoney);
    }

    public void triceCombinations(int n, int m, int p, int totalMoney) {
        for (int i = 1; i <= totalMoney / n; i++) {
            for (int j = 1; j <= totalMoney / m; j++) {
                for (int k = 1; k <= totalMoney / p; k++) {
                    if (n * i + m * j + p * k == totalMoney) {
                        System.out.println(n + " is  " + i + " times and  " + m + " is " + j + " times and " + p + " is " + k + " times");
                    }
                }
            }
        }
    }
    public void combinations(int n, int m, int totalMoney) {
        for (int i = 1; i <= totalMoney / n; i++) {
            for (int j = 1; j <= totalMoney / m; j++) {
                if (n * i + m * j == totalMoney) {
                    System.out.println(n + " is " + i +  " times and " + m + " is " + j + " times");
                }
            }
        }
    }
    public void singleCombination(int n, int totalMoney) {
        int i = totalMoney / n;
        System.out.println(n + " is " + i + " times");
    }
}
