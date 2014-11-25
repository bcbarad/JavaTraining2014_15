package com.vl.sf.core;

public class FindSecondHighestNumber {
    public int secondHighestNumberFinder(int[] arr){
        int maxNumber=arr[0];
        int secondHighestNumber=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(maxNumber<arr[i]){
                secondHighestNumber=maxNumber;
                maxNumber=arr[i];
            }else if(arr[i]>secondHighestNumber){
                secondHighestNumber=arr[i];
            }
        }
        return secondHighestNumber;
    }
    public static void main(String[] args){
        FindSecondHighestNumber fn=new FindSecondHighestNumber();
        int[] arr=new int[]{1,100,9, 20, 30, 40};
        System.out.println("The Second Highest number is "+fn.secondHighestNumberFinder(arr));
    }
}
