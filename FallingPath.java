package com.Aug2020.dp3;

public class FallingPath {
	   public static int minFallingPathSum(int[][] A) {
	       int n = A.length;
	int m = A[0].length;
	int dp[][] = new int[n][m];

		for (int j = 0; j < m; j++) {
			dp[0][j] = A[0][j];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int x = (j - 1 < 0) ? Integer.MAX_VALUE : dp[i - 1][j - 1];
				int y = (j + 1 >= m) ? Integer.MAX_VALUE : dp[i - 1][j + 1];
				int z = dp[i - 1][j];

				dp[i][j] = Math.min(x, Math.min(y, z)) + A[i][j];
			}
		}

		int ans = Integer.MAX_VALUE;

		for (int j = 0; j < m; j++) {
			ans = Math.min(ans, dp[n - 1][j]);
		}

		return ans;
	    }
	   
	   
	   public static void main(String[] args) {
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(" value with smallest sum => "+minFallingPathSum(arr));
	}
}
