package com.vl.utms.grabber;

public class SpiralMatrix {
	
	public static void main(String[] args) {
		//Input Should be a rectangular Matrix
		char[][] arr = {{'a', 'b', 'c'}, {'1', '2', '3'}, {'l', 'm', 'n'}, {'p', 'q', 'r'}};
		int rows = arr.length;
		int cols = arr[0].length;
		System.out.print("Input Matrix:\n");
		printInput(arr, rows, cols);
		System.out.print("\nSpiral Sequence:\t");
		printSpiral(arr, rows, cols);
	}

	private static void printSpiral(char[][] arr, int rows, int cols) {
		if(rows > 0) {
		char[][] newArr = new char[cols][rows-1];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(i == 0) {
					System.out.print(arr[i][j]);
				}else {
					newArr[cols-(j+1)][i-1] = arr[i][j];
				}
			}
		}
		printSpiral(newArr, cols, rows-1);
		}
	}

	private static void printInput(char[][] arr, int rows, int cols) {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
