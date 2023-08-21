// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;
        int min = Integer.MAX_VALUE;

        int[][] dp = new int[m][n];

       for(int i=0;i< n;i++)
       {
           dp[0][i]= matrix[0][i];  // Take the intial row into the dp array
       }

        for(int i=1; i< m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j==0)
                {
                    dp[i][j] = matrix[i][j]+ Math.min(dp[i-1][j],dp[i-1][j+1]);  // edge case
                }
                else if(j==n-1)
                {
                    dp[i][j] = matrix[i][j]+ Math.min(dp[i-1][j],dp[i-1][j-1]); // edge case
                }
                else
                dp[i][j] =  matrix[i][j]+ Math.min(dp[i-1][j], Math.min(dp[i-1][j+1],dp[i-1][j-1]));
            }
        }

        for(int i=0;i< n;i++)
       {
        min = Math.min(min, dp[m-1][i]);  
       }
      return min;  
    }
}