// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class minFallingSum {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int sum = Integer.MAX_VALUE;       
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < dp.length; i++)
        {
            for(int j = 0; j < dp[0].length; j++)
            {
                dp[i][j] = matrix[i][j];
            }
        }
        
        for(int i = dp.length - 2; i >= 0; i--)
        {
            for(int j = 0; j < dp[0].length; j ++)
            {
                if(j == 0)
                {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                }
                
                else if (j == dp[0].length - 1)
                {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
                }
                else
                {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j + 1], dp[i + 1][j - 1]));
                }
            }
        }
        
        for(int i = 0; i < dp[0].length; i++)
        {
            sum = Math.min(sum, dp[0][i]);
        }
        
        return sum;
    }
}