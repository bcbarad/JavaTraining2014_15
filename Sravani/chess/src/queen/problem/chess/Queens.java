//import java.lang.Math;
package queen.problem.chess;
public class Queens {
    public static final int SIZE = 8;
    private static int[] x = new int[SIZE];
    public static void main(final String[] args) {
        int row = 0 , col = 0;
        Queens c = new Queens();
        c.canPlace(row , col);
    }
    public final void canPlace(final int row , final int col) {
        Queens q = new Queens();
        int j = col;
        for (; j < SIZE; j++) {
            if (q.isSafe(row , j)) {
                x[row] = j;
                if (row == (SIZE - 1)) {
                    q.printQueens();
                } else {
                    canPlace(row + 1 , 0);
                }
            }
        }
    }
    public final boolean isSafe(final int row , final int col) {
        for (int i = 0; i < row; i++) {
            if ((x[i] == col) || (Math.abs(x[i] - col) == Math.abs(row - i))) {
                return false;
            }
        }
        return true;
    }
    public final void printQueens() {
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print("(" + i + "," + x[i] + ")");
        }
    }
}
