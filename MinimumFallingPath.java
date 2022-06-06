// Time Complexity : O(NM)
// Space Complexity : O(NM)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// This is the bottom up dp solution
// This problem is similar to PaintHouse to get Min Cost
class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;

        int[][] dp = new int[r][c];

        // Initialize the dp array - only the last roq
        for (int j = 0; j < c; j++) {
            dp[r - 1][j] = matrix[r - 1][j];
        }

        // Start with second last row
        for (int i = r - 2; i >= 0; i--) {
            for (int j = 0; j < c; j++) {

                // Get the minimum from valid values
                // Check the edge cases where u are located at the ends
                int a = j == 0 ? Integer.MAX_VALUE : dp[i + 1][j - 1];
                int b = dp[i + 1][j];
                int z = j == c - 1 ? Integer.MAX_VALUE : dp[i + 1][j + 1];

                int min = Math.min(a, Math.min(b, z));

                // update the values
                dp[i][j] = min + matrix[i][j];

            }

        }

        int ans = Integer.MAX_VALUE;

        // Get the min from the first row
        for (int j = 0; j < c; j++) {

            ans = Math.min(ans, dp[0][j]);
        }

        return ans;
    }
}