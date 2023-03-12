// Time Complexity : O(mn); m = matrix.length; n = matrix[0].length
// Space Complexity : O(mn); m = matrix.length; n = matrix[0].length
// Did this code successfully run on Leetcode : Yes
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        // Build dp 2D array bottom up, fetch minimum possible from direction up, up-left and up-right
        // adding to it's own value.
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int up = i - 1 >= 0 ? dp[i-1][j] : Integer.MAX_VALUE;
                int upLeft = i - 1 >= 0 && j - 1 >= 0 ? dp[i-1][j-1] : Integer.MAX_VALUE;
                int upRight = i - 1 >= 0 && j + 1 < n ? dp[i-1][j+1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(Math.min(up, upLeft),upRight);
            }
        }

        int minSum = dp[m-1][0];
        for(int j = 1; j < n; j++) {
            minSum = Math.min(minSum, dp[m-1][j]);
        }

        return minSum;
    }
}