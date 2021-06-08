// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution2 {
    public int minFallingPathSum(int[][] matrix) {
        // 1. we construct dp table of (n x n) matrix
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // 2. initializing first row of dp as it is for further calculations
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        // 3. iterate and compute the dp table
        int min = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    // left border of the matrix
                    min = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == n - 1) {
                    // right border of the matrix
                    min = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                } else {
                    // in between
                    min = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]);
                }
                dp[i][j] = matrix[i][j] + min;
            }
        }

        // finally, get the minimum sum amoung the last row of dp
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum, dp[n - 1][i]);
        }

        return minSum;
    }
}
