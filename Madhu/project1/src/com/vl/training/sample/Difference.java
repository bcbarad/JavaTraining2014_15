package com.vl.training.sample;
import java.util.Scanner;
public class Difference {
	static boolean checkDiff(final int list[]) {
		int[] diff = new int[50];
		int i = 0;
		for ( ; list[i + 1] != '\0'; i++) { //to store the differences of cosecutive elements in diff arra
			if (list[i] > list[i + 1])
				diff[i] = list[i] - list[i + 1];
			else
				diff[i] = list[i + 1] - list[i];
			System.out.println(diff[i]);
		}
		for (int j = 0; j < i; j++) {// to check the duplicate diffrence elements
			for (int k = j + 1; k < i; k++){
				if (diff[j] == diff[k])
					return false;
			}
		}
		return true;
	}
	public static void main(String args[]) {
		int[] list = new int[50];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of  elements");
		int num = sc.nextInt();
		System.out.println(" enter elements");
		for (int i = 0; i < num; i++) {
			list[i] = sc.nextInt();
		}
		boolean res = Difference.checkDiff(list);
		if (res)
			System.out.println("duplicate difference not exist");
		else
			System.out.println("duplicate difference exist");
	} 
}
