// Time Complexity : O(n*n)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class MinimumFallPathSum {
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix[0].length;
            int dp[][] = new int[n][n];

            for(int j = 0; j < n; j++){
                dp[0][j] = matrix[0][j];
            }

            for(int i = 1; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(j < 1){
                        dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                    }
                    else if(j == n-1){
                        dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                    }
                    else{
                        dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1]));
                    }
                }
            }

            int minPath = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                minPath = Math.min(minPath, dp[n-1][i]);
            }

            return minPath;
        }
    }
}
