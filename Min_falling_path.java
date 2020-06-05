
// Time Complexity : Doubt
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Time Complexity not understood
import java.util.Arrays;

public class Min_falling_path {
	public static int minFallingPathSum(int[][] A) {
		/*
		 * m = row n = column
		 */
		int m = A.length;
		int n = A[0].length;
		// edge case is handled
		if (m == 0) {
			return 0;
		}
		/*
		 * We iterate from the second row of the 2d array and for each index we find the
		 * minimum from the previous row taking into account the constraints given in
		 * the problem statement and add it to the current index, thus in the end the
		 * whole row would be modified
		 */
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					A[i][j] = A[i][j] + Math.min(A[i - 1][j], A[i - 1][j + 1]);
				} else if (j == n - 1) {
					A[i][j] = A[i][j] + Math.min(A[i - 1][j], A[i - 1][j - 1]);
				} else {
					A[i][j] = Math.min(A[i - 1][j - 1], Math.min(A[i - 1][j], A[i - 1][j + 1])) + A[i][j];
				}
			}
		}
		/*
		 * We sort the last row and return the first element in the last row
		 */
		Arrays.sort(A[m - 1]);
		return A[m - 1][0];
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int min_sum = minFallingPathSum(arr);
		System.out.println("Minimum Sum : " + min_sum);
	}
}