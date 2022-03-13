// Time Complexity : O(n^2) where n is the row length of matrix
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// CODE

public class minimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];
        // top-down approach
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j]; // filling first row with same values of matrix in first row
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;

                if (i - 1 >= 0) { // checking if above row exists
                    min = Math.min(dp[i - 1][j], min);
                }
                if (i - 1 >= 0 && j - 1 >= 0) { // checking if above row left block exists
                    min = Math.min(min, dp[i - 1][j - 1]);
                }
                if (i - 1 >= 0 && j + 1 < n) { // checking if above row right block exists
                    min = Math.min(min, dp[i - 1][j + 1]);
                }

                dp[i][j] = matrix[i][j] + min; // value in dp array will be value in matrix at that position + min among
                                               // three blocks(j,j-1,j+1) in above row
            }
        }
        // finding min of last row of dp matrix
        int ans = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}
