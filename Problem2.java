// Time Complexity : O(M*N)
// Space Complexity : O(M+N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];

        // last row would be same
        for(int i = 0; i < n; i++)
        {
            dp[m -1][i] = matrix[m - 1][i];
        }

        // start from 2nd last row
        for(int i = m - 2; i >= 0; i--)
        {
            for(int j = 0; j < n; j++)
            {
                // if j == 0 then add min of immediate down or diagonally right element
                // if j == matrix.length - 1 then add min of immediate down or diagonally left element
                // else min of down, left, right
                if(j == 0)
                {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
                else if(j == matrix.length - 1)
                {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j-1], dp[i+1][j]);
                }
                else
                {
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i+1][j-1], dp[i+1][j]), dp[i+1][j+1]);
                }
            }
        }

        int min = dp[0][0];

        for(int j = 0; j < n; j++) {
            min = Math.min(min, dp[0][j]);
        }

        return min;
    }
}