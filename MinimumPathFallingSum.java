package com.example.problems;

import java.util.Arrays;

public class MinimumPathFallingSum {
	public int minFallingPathSum(int[][] A) {
		if (A == null || A[0].length == 0) {
			return 0;
		}
		int row = A.length;
		int col = A[0].length;
		int dp[][] = new int[row][col];

		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (j == 0) {
					A[i][j] += Math.min(A[i - 1][j], A[i - 1][j + 1]);
				} else if (j == col - 1) {
					A[i][j] += Math.min(A[i - 1][j - 1], A[i - 1][j]);

				} else if(i < row && j < col) {
					A[i][j] += Math.min(A[i - 1][j + 1], Math.min(A[i - 1][j - 1], A[i - 1][j]));
				}
			}
		}
		System.out.println(Arrays.deepToString(A));
		int ans = Integer.MAX_VALUE;
        for (int x: A[col - 1])
            ans = Math.min(ans, x);
        return ans;
	}

	public static void main(String args[]) {
		int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		MinimumPathFallingSum sum = new MinimumPathFallingSum();
		
		System.out.println(sum.minFallingPathSum(A));
	}
}
