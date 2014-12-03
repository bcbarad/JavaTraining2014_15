package com.vl.training.sample;

public class CountSets {

    // Usage: First element of the array represents amount, and the rest of the elements are denominations
    // Assumption: Denominations are in sorted order
    public static void main(String args[]) {
        if(args.length < 2) {
            System.err.println("Invalid usage: pass Amount and Denominations as parameters");
            return;
        }

        int amount = Integer.parseInt(args[0]);

        // Create an array for denominations with rest of the arguments
        int denominations[] = new int[args.length-1];
        for(int i = 1; i < args.length; i++) {
            denominations[i-1] = Integer.parseInt(args[i]);
        }

        int numberOfSets = countSubsets(amount, denominations);
        System.out.println("Total sets = " + numberOfSets);
    }

    public static int countSubsets(int amount, int[] denominations) {
        // No money or no denominations
        if(amount < 0 || denominations.length == 0)
            return 0;
        // The first element of the denominations is equal to the amount
        if(amount == denominations[0])
            return 1;

        // Create another array without the first element
        // This would have been eary with Collections.List
        int[] tail = getTail(denominations);

        // Entire Logic is in this statement
        return countSubsets((amount - denominations[0]), denominations)
            + countSubsets(amount, tail);
    }

    private static int[] getTail(int[] list) {
        if(list == null || list.length == 0)
            return null; // Might indicate an error
        int[] newList = new int[list.length -1];

        for(int i = 0; i < newList.length; i++)
            newList[i] = list[i+1];

        return newList;
    }
}
