// 931. Minimum Falling Path Sum - https://leetcode.com/problems/minimum-falling-path-sum/
// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minFallingPathSum(int[][] matrix) 
    {
        // Data Structure
        int dp[][] = new int[matrix.length+1][matrix.length];
        int res=Integer.MAX_VALUE;
        
        for (int i=1;i<dp.length;i++)
        {
            for (int j=0;j<matrix.length;j++)
            {
                int minLastRow = dp[i-1][j];
                if (j>0)
                {
                    minLastRow = Math.min(minLastRow, dp[i-1][j-1]);
                }
                if (j<matrix.length-1)
                {
                    minLastRow = Math.min(minLastRow, dp[i-1][j+1]);
                }   
                dp[i][j] = matrix[i-1][j] + minLastRow;
                if (i==dp.length-1)
                {
                    res=Math.min(res,dp[i][j]);
                }
            }
        }
        return res;
    }
}