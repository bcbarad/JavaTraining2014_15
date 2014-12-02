package com.vl.sf.core;

public class Coins {

        static int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        static long M1 = 0;

        public static long pay(int money) {
                int typesOfCoins = coins.length;
                long totalNofCombinations = getCombinations(money, typesOfCoins);
                return totalNofCombinations;
        }

        private static long getCombinations(int money, int typesOfCoins) {

                if (typesOfCoins == 1) {
                        return 1;
                }
                if (money == 0){
                        return 1;
                }
                if (money < 0){
                        return 0;
                }
                M1 = getCombinations(money, typesOfCoins - 1) + getCombinations(money -
coins[typesOfCoins - 1], typesOfCoins);
                return M1;
        }

        public static void main(String[] args) {
                int money =Integer.parseInt(args[0]);
                if(money>0){
                    long totalNofCombinations = pay(money);
                    System.out.println("Total "+totalNofCombinations+" number of combinations can be done for Rs."+money);
                }
                else{
                        System.out.println("Coins are not available for U");
                }

        }
}

