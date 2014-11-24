package com.vl.training.sample;
import java.util.Scanner;
public class Mode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of elements");
        int num = sc.nextInt();
        int[] n = new int[num];
        System.out.println(" enter elements");
        for (int i = 0; i < num; i++) {
            n[i] = sc.nextInt();
        }
        int res = Mode.Find(n);
        System.out.println("mode is" + res);
    }
    static int Find(int[] n) {
        int mode = n[0];
        int temp = 1;
        int temp2 = 1;
        for (int i = 1; i < n.length; i++) {
            if (n[i - 1] == n[i]) {
                temp++;
            }
            else {
                temp = 1;
            }
            if (temp >= temp2) {
                mode = n[i];
                temp2 = temp;
            }
        }
        return mode;
    }
}
