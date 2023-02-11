// Time Complexity : O(n*n)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I created a dp array with same dimensions as that of matrix array and copied the elements of the first row of the matrix array to it.
 * For every other row, I calculate dp[i][j] as the sum of matrix[i][j] + min(dp[i-1][j],dp[i-1][j-1] & dp[i-1][j+1]). For the
 * first and last column elements, I ensure that column-1 and column+1 elements aren't checked respectively.ß
 */
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int dp[][] = new int[rows][columns];
        for(int j=0;j<columns;j++)
        {
            dp[0][j]=matrix[0][j];
        }
        for(int i=1;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if(j==0)
                {
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
                }
                else if(j==columns-1)
                {
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
                }
                else
                {
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i-1][j+1]));
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int j=0;j<columns;j++)
        {
            ans=Math.min(ans,dp[rows-1][j]);
        }
        return ans;
    }
}