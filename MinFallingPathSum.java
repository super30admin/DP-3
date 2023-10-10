/* Time Complexity : O(n*n)
 * 	n - rows/cols in the input - matrix */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


public class MinFallingPathSum {
	public int minFallingPathSum(int[][] matrix) {

		if (matrix == null)
			return 0;
		int n = matrix.length;

		int min = Integer.MAX_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if(i != n-1) {
					//left wall or boundry
					if (j == 0) {
						matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
					}
					//right wall or boundry
					else if (j == n - 1) {
						matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j - 1], matrix[i + 1][j]);
					}
					else {
						matrix[i][j] = matrix[i][j]
								+ Math.min(matrix[i + 1][j - 1], Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]));
					}		
				}
				if (i == 0)
					min = Math.min(min, matrix[i][j]);
			}
		}

		return min;

	}
}
