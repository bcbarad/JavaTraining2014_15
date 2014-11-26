package com.vl.training.sample;
public class Mode {
	public static void main(final String[] args) {
		int[] arr = new int[args.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(args[i]);
		}
		Mode.getMode(arr);
	}
	static void getMode(final int[] arr) {
		int crrMode = arr[0], tmpFrq= 1,i;
		int crrFrq = 1;
		for (i = 0; i < arr.length-1; i++) {
			if (arr[i] == arr[ i+1 ]) {
				tmpFrq++;
			}
			else {
				tmpFrq = 1;
			}

			if (tmpFrq >= crrFrq ) {
				crrMode = arr[ i ];
				crrFrq  = tmpFrq ;


			}
		}
		System.out.println("The highest frequency " + crrFrq);
		System.out.println("element is" + crrMode); 
	}
}
