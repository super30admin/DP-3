// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {

        if (matrix.length == 0 || matrix == null) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = matrix[m - 1][i];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                } else if (j == n - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j - 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
                }
            }
        }

        int minimumSum = dp[0][0];

        for (int i = 1; i < n; i++) {
            minimumSum = Math.min(minimumSum, dp[0][i]);
        }

        return minimumSum;
    }

}