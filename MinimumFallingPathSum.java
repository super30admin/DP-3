class Solution {
    // Time Complexity : O(mn), where m is the rows of the matrix and n is the cols of the matrix
    // Space Complexity : O(mn)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    public int minFallingPathSum(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int[][] dp = new int[r][c];

        for(int j = 0; j < c; j++) {
            dp[0][j] = matrix[0][j];
        }

        for(int i = 1; i < r; i++) {
            for(int j = 0 ; j < c; j++) {
                if(j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                } else if(j == c-1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < c; j++) {
            min = Math.min(min, dp[r-1][j]);
        }
        return min;
    }
}