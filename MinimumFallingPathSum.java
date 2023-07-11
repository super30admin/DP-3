// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length != matrix.length)return -1;
        int l =matrix.length;;
        int dp[][] = new int[l][l];

        for(int i=0;i<l;i++) {
            dp[l-1][i] = matrix[l - 1][i];
        }

        for(int i=matrix.length-2; i>=0; i--)
        {
            for(int j=0; j<l; j++)
            {
                if(j == 0)
                {
                    dp[i][j] = matrix[i][j]+Math.min(dp[i+1][j],dp[i+1][j+1]);
                }
                else if(j == l-1)
                {
                    dp[i][j] = matrix[i][j]+Math.min(dp[i+1][j-1],dp[i+1][j]);
                }
                else {
                    dp[i][j] = matrix[i][j]+Math.min(dp[i+1][j-1],Math.min(dp[i+1][j],dp[i+1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ;i < dp.length; i++)
        {
            min = Math.min(min,dp[0][i]);
        }
        return min;
    }
}
