// Time Complexity : O(n*n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

package problem2;

public class MinimumFallingPathSum {
	public int minFallingPathSum(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		int n = matrix.length;
		int min = Integer.MAX_VALUE;

		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
				} else if (j == n - 1) {
					matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
				} else {
					matrix[i][j] += Math.min(matrix[i + 1][j], Math.min(matrix[i + 1][j + 1], matrix[i + 1][j - 1]));
				}
			}
		}

		for (int j = 0; j < n; j++) {
			if (matrix[0][j] < min) {
				min = matrix[0][j];
			}
		}

		return min;
	}

	public static void main(String[] args) {
		MinimumFallingPathSum obj = new MinimumFallingPathSum();
		int[][] arr = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
		System.out.println("Minimum falling path sum in the array: "+obj.minFallingPathSum(arr));
	}

}
