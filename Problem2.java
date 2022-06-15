// Time Complexity : O(m*n) where m is the number of matrices, n is each matrix length
// Space Complexity : O(m*n) where m is the number of matrices, n is each matrix length
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i += 1) {
            dp[m - 1][i] = matrix[m - 1][i];
        }

        for (int i = m - 2; i >= 0; i -= 1) {
            for (int j = 0; j < n; j += 1) {
                if (j == 0)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                else if (j == n - 1)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
                else
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j - 1], dp[i + 1][j + 1]));
            }
        }

        for (int i = 0; i < n; i += 1) {
            if (dp[0][i] < min)
                min = dp[0][i];
        }

        return min;
    }
}