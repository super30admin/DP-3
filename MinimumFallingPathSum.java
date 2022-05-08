// Time Complexity : O(n*m) n = rows, m = column
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {

        if(matrix.length == 1) return matrix[0][0];
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j == n - 1) dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                else if(j == 0) dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                else dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
                if(i == m - 1) min = Math.min(min, dp[i][j]);
            }
        }
        return min;
    }
}