// time complexity is O(M*N) i.e the row*Column
// space complexity is O(1) as we are using the input matrix only
// Solution is submitted on leetcode

public class BigN23MinimumFallingSumUsingInputMatrix {
	
	public int minFallingPathSum(int[][] A) {
		// edge case
		if (A == null || A.length == 0)
			return 0;
		int min = Integer.MAX_VALUE;
		int row = A.length;
		int column = A[0].length;
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (j == 0) {
					A[i][j] = A[i][j] + Math.min(A[i - 1][j], A[i - 1][j + 1]);
				} else if (j == column - 1) {
					A[i][j] = A[i][j] + Math.min(A[i - 1][j], A[i - 1][j - 1]);
				} else {
					A[i][j] = A[i][j] + Math.min(A[i - 1][j], Math.min(A[i - 1][j - 1], A[i - 1][j + 1]));
				}
			}
		}
		for (int i = 0; i < column; i++) {
			if (min > A[row - 1][i]) {
				min = A[row - 1][i];
			}
		}
		return min;
	}
}
