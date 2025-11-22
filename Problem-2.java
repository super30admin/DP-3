// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//Use a DP array dp[i][j] to store the minimum falling path sum ending at cell (i, j).
// For each cell, update dp[i][j] = matrix[i][j] + min(dp[i-1][j], dp[i-1][j-1], dp[i-1][j+1]) with proper boundary checks.
// Return the minimum value in the last row of dp as the result.

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Copy of matrix for DP
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i > 0) {
                    int up = dp[i-1][j];
                    int upLeft = (j-1 >= 0) ? dp[i-1][j-1] : Integer.MAX_VALUE;
                    int upRight = (j+1 < m) ? dp[i-1][j+1] : Integer.MAX_VALUE;

                    dp[i][j] = matrix[i][j] + Math.min(up, Math.min(upLeft, upRight));
                }
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minSum = Math.min(minSum, dp[n-1][j]);
        }

        return minSum;
    }
}
