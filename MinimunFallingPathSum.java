// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinimunFallingPathSum {
    public int minFallingPathSum(int[][] matrix) 
    {
        int dp[][] = new int[matrix.length+1][matrix.length];
        int res = Integer.MAX_VALUE;

        for (int i=1; i<dp.length; i++) {
            for (int j=0;j<matrix.length;j++) {
                int min = dp[i-1][j];
                if (j>0)
                   min = Math.min(min, dp[i-1][j-1]);
                
                if (j<matrix.length-1)
                   min = Math.min(min, dp[i-1][j+1]);
                 
                dp[i][j] = matrix[i-1][j] + min;
                if (i==dp.length-1)
                    res=Math.min(res,dp[i][j]);
            }
        }
        return res;
    }
}