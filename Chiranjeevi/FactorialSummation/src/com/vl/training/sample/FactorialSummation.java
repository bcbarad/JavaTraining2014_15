package com.vl.training.sample;

public class FactorialSummation {
    public static void main(String arr[]) {
    int n = Integer.parseInt(arr[0]);
    System.out.println("Sigma " + n + "!= " + factSummation(n));
    }
    public static int factSummation(int n) {
        int sum = 0, j = 0, temp = 1;
        for (int i=1; i <= n; i++){
            //temp, sum are integer variables
            sum = sum + temp;
            j+=2;
            temp = temp * j * (j - 1);
        }
        return sum;
    } 
}
