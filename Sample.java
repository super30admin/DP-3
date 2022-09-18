// Minimum Falling Path Sum
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach
 
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int min=0;
        if(matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;
        if(matrix.length == 1) 
            return matrix[0][0];
        int dp[][] = new int[n][n];
        
        //Filling the last row
        for(int j=0;j<n;j++)
        {
            dp[n-1][j]=matrix[n-1][j];
        }
        
        for(int i=n-2; i>=0; i--)
        {
            for(int j=0;j<n;j++)
            {
                if(j==0)
                {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
                else if(j==n-1)
                {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j-1]);   
                }
                else
                {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], Math.min(dp[i+1][j+1], dp[i+1][j-1]));                    
                }
        
            }
        }
        
        min = dp[0][0];
        for(int j=1;j<n;j++)
        {
        min = Math.min(min,dp[0][j]);
        }
        return min;
    }
}
                                                       