// Time Complexity :O(n*n)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int n = matrix.length;
        int dp[][] = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }
        for (int i = n - 2; i >= 0; i--) {
            for(int j=0;j<n;j++){
                if(j==0){
                    dp[i][j] = matrix[i][j] + Integer.min(dp[i + 1][j], dp[i + 1][j+1]);
                }else if(j==n-1){
                    dp[i][j] = matrix[i][j] + Integer.min(dp[i + 1][j], dp[i + 1][j-1]);
                }else{
                     dp[i][j] = matrix[i][j] + Integer.min(dp[i + 1][j], Integer.min(dp[i + 1][j-1],dp[i + 1][j+1]));
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            min=Math.min(min,dp[0][j]);
        }
        return min;
    }
}