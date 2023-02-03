// Time Complexity : O(MN) M & N are dimensions of matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach

/**
 * Similar to painting house problem, keeping the first row as it as and applying the condition
 * on next rows. If the column is 0, the do not consider the left diagonal element. If the column
 * is last column, then do not consider the right diagonal element. For remaining cases, consider
 * all three possible elements to find the min value to be added to the current value.
 * From the last row, take the min of all the elements and return the min.
 *
 */
class MinFallingPath {
	public int minFallingPathSum(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					matrix[i][j] += Math.min(matrix[i - 1][0], matrix[i - 1][1]);
				} else if (j == n - 1) {
					matrix[i][j] += Math.min(matrix[i - 1][n - 1], matrix[i - 1][n - 2]);
				} else {
					matrix[i][j] += Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]));
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++)
			ans = Math.min(ans, matrix[m - 1][i]);
		return ans;
	}
}