package com.vl.training.sample;

public class Queens {

    public static void main(final String []args) {
        int[] arr = new int[8];
        int queen = 0;
        Queens.getPosition(queen, arr);
    }

    final boolean getQueen(final int col, final int queen, final int []arr) {
        boolean f1 = true, f2 = true, f3 = false;
        for (int k = 0; k < queen; k++) {
	    if (arr[k] == col) {
                f1 = false;
            }
	    int c = Math.abs(arr[k] - col);
            int b = Math.abs(k - queen);
	    if (c == b) {
                f2 = false;
            }
	}
	if (f1 && f2) {
            f3 = true;
        }
	return f3;
    }

    public static void getPosition(final int queen, final int []arr) {
        boolean f = false;
	if (queen == 8) {
            System.out.println("+++++++++++++++++++the possible solutions ++++++++++++++++++++");
	    for (int k = 0; k < 8; k++) {
                System.out.println("position(x,y)" + "(" + k + " " + arr[k] + ")");
		if (k == 7) {
		    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
		}
	    }
	} else {
	    Queens q = new Queens();
	    for (int col = 0; col < 8; col++) {
	        f = q.getQueen(col, queen, arr);
                if (f) {
                    arr[queen] = col;
                    getPosition(queen + 1, arr);
		}
            }
	}

    }
}

