// Time Complexity : O(N) where N is the total number of elements in the matrix
//                  i.e n^2
// Space Complexity : O(n^2) for extra 2D array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution
{
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        if(n==1) return matrix[0][0];

        // random num value, value in matrix can never cross this value
        int min = 2010000;

        int[][] dp = new int[n+1][n+2];

        // padding the dp array with outer max values to avoid checking for
        // overflows when we iterate through the dp matrix.
        for(int i = 0; i < n; i++)
        {
            dp[i][0] = 2010000;
            dp[i][n+1] = 2010000;
        }

        for(int row = 1; row < n+1; row++)
        {
            for(int col = 1; col < n+1; col++)
            {
              int temp = 0;

              //finding minimum of three (2 diagonal and 1 same col) indices on
              // the above row, as it can come from only these three rows.
              if(dp[row-1][col-1] < dp[row-1][col]){
                  temp = dp[row-1][col-1];
              }
              else{
                  temp = dp[row-1][col];
              }

              if(temp > dp[row-1][col+1])
                  temp = dp[row-1][col+1];

              //updating the dp matrix
              dp[row][col] = matrix[row-1][col-1] + temp;

              // keeping track of min when we traverse last row
              if(row == n)
                    min = min <  dp[row][col] ? min : dp[row][col];
            }
        }

        return min;
    }
}
