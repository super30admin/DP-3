// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * Using tabulation to break the problem into smaller subproblems. Set the last row as is and started calculating least falling path sum from second last row.
 * First row's minimum will get us the answer for the minimum falling sum.
 */
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int belowMin = Integer.MAX_VALUE;
                // just have to check below and below-right if beginning of the array
                if (j == 0) {
                    belowMin = Math.min(belowMin, Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
                }
                // just have to check below and below-left if the end of the array
                else if (j == n - 1) {
                    belowMin = Math.min(belowMin, Math.min(dp[i + 1][j], dp[i + 1][j - 1]));
                }
                // have to check all bottom neighbors to get the minimum sum
                else {
                    belowMin = Math.min(belowMin, Math.min(dp[i + 1][j], Math.min(dp[i + 1][j - 1], dp[i + 1][j + 1])));
                }

                dp[i][j] = matrix[i][j] + belowMin;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[0][j]);
        }

        return ans;

    }
}