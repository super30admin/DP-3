// Time Complexity : O(mn) 
// Space Complexity : O(1) ---> As no explicit DS Defined
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinFallingPath {
	public int minFallingPathSum(int[][] A) {
		if (A == null || A.length == 0)
			return 0;
		int min = Integer.MAX_VALUE;
		int m = A.length;

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if (j == 0) {
					A[i][j] = A[i][j] + Math.min(A[i - 1][j], A[i - 1][j + 1]);
				} else if (j == m - 1) {
					A[i][j] = A[i][j] + Math.min(A[i - 1][j], A[i - 1][j - 1]);
				} else {
					A[i][j] = A[i][j] + Math.min(A[i - 1][j - 1], Math.min(A[i - 1][j], A[i - 1][j + 1]));
				}
			}
		}

		for (int i = 0; i < m; i++) {
			if (min > A[m - 1][i]) {
				min = A[m - 1][i];
			}
		}
		return min;
	}
}