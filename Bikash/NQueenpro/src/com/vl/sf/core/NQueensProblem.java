package com.vl.sf.core;
public class NQueensProblem {
   static int total=1;
  
    public static boolean isConsistent(int[] queenPositions, int queenAllocatedColumn) {
    	for (int i = 0; i < queenAllocatedColumn; i++) {
			if (queenPositions[i] == queenPositions[queenAllocatedColumn]
					|| Math.abs(queenPositions[i]
							- queenPositions[queenAllocatedColumn]) == (queenAllocatedColumn - i)) {
				return false;
			}
		}
		return true;
    }
   
    public static int[] queenPositions(int[] queenPositions,int queenAllocatedColumn) {
        int N = queenPositions.length;
        if (queenAllocatedColumn == N) printQueens(queenPositions);
        else {
            for (int i = 0; i < N; i++) {
            	queenPositions[queenAllocatedColumn] = i;
                if (isConsistent(queenPositions, queenAllocatedColumn)) queenPositions(queenPositions, queenAllocatedColumn+1);
            }
        }
        return queenPositions;
    }  

    public static void printQueens(int[] queenPositions) {
        int length = queenPositions.length;
        System.out.println("\t"+total++);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (queenPositions[i] == j) System.out.print("@ ");
                else           System.out.print("* ");
            }
            System.out.println();
        }  
        
    }
    
    public static void main(String[] args) {
    	int[] queenPositions=new int[8];
    	queenPositions=queenPositions(queenPositions,0);
    }

}