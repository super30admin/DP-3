// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
       int n = matrix.length;
       int [][] dp = new int [n][n];
       for(int i=0; i<n; i++)
       {
           dp[0][i] = matrix[0][i];
       }
        for(int i = 1; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(j == 0)
                {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                }
                else if(j == n-1)
                {
                     dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
                else
                {
                    dp[i][j]  = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j+1],dp[i-1][j-1]));
                }
            }
        }
         int min = Integer.MAX_VALUE;
        for(int j = 0; j<n; j++)
        {
            min = Math.min(min, dp[n-1][j]);
        }
        return min;
    }
}