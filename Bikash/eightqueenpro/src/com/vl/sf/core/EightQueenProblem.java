package com.vl.sf.core;

public class EightQueenProblem {
	public static boolean isSafe(int[] queenPositions, int queenAllocatedColumn) {
		for (int i = 0; i < queenAllocatedColumn; i++) {

			if (queenPositions[i] == queenPositions[queenAllocatedColumn]
					|| Math.abs(queenPositions[i]
							- queenPositions[queenAllocatedColumn]) == (queenAllocatedColumn - i)) {
				return false;
			}
		}
		return true;
	}

	public static int[] queenPositions(int[] queenPositions) {

		int queenAllocatedColumn = 0;

		for (int j = 0; j < 8; j++) {
			int checkStartingLocation = 0;
			for (int i = checkStartingLocation; i < 8; i++) {
				queenPositions[queenAllocatedColumn] = i;
				boolean status = isSafe(queenPositions, queenAllocatedColumn);
				if (status) {
					queenAllocatedColumn++;
					break;
				} else if (i == 7) {

					i = backTrack(queenPositions, queenAllocatedColumn--);
					if (i == 7) {
						i = backTrack(queenPositions, queenAllocatedColumn--);
					} else {
						queenPositions[queenAllocatedColumn] = 0;
					}
					j = queenAllocatedColumn;
					checkStartingLocation = i + 1;

				}

			}

		}
		return queenPositions;
	}

	public static int backTrack(int[] queenPositions, int queenAllocatedColumn) {
		queenPositions[queenAllocatedColumn] = 0;
		queenAllocatedColumn--;
		return queenPositions[queenAllocatedColumn];
	}

	public static void printQueens(int[] queenPositions) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (queenPositions[i] == j)
					System.out.print("@ ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] queenPositions = new int[8];
		queenPositions=queenPositions(queenPositions);
		printQueens(queenPositions);
	}

}
