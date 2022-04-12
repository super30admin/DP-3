/**
Problem: Minimum falling path sum
https://leetcode.com/problems/minimum-falling-path-sum/

TC = O (n * m)
SC = O (n * m)
*/
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int dp[][] = new int[rows][cols];
        
        for (int i = 0; i < cols; ++i) {
            dp[0][i] = matrix[0][i];
        }
        
        for (int i = 1; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                } else if (j == cols - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1]));
                }
            }
        }
        
        int minCost = dp[rows-1][0];
        for (int i = 1; i < cols; ++i) {
            minCost = Math.min(minCost, dp[rows-1][i]);
        }
        return minCost;
    }
}
