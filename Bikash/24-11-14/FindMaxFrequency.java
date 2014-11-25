package com.vl.sf.core;

public class FindMaxFrequency {
	public int maxFrequencyFinder(int[] arr) {
		int maxRepeat = 1;
		int maxRepeatNumber = 0;
		int repeat = 1;
		int i;
		for (i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				repeat++;

			} else {
				if (repeat >= maxRepeat) {
					maxRepeat = repeat;
					maxRepeatNumber = arr[i];
				}
				repeat = 1;
			}
		}
		if (repeat >= maxRepeat) {
			maxRepeatNumber = arr[i];
		}
		return maxRepeatNumber;
	}

	public static void main(String[] args) {
		FindMaxFrequency fm = new FindMaxFrequency();
		int[] arr = new int[] { 1, 1, 5, 5, 6, 6, 6,7,7,7, 7 };
		System.out.println("The Highest Frequency Number is "
				+ fm.maxFrequencyFinder(arr));
	}

}
