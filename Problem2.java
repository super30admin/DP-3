
//931.
// Time Complexity : O(n) array length (no. of houses)
// Space Complexity : O(N*N) 2D matrix
// Did this code successfully run on Leetcode : Yes

class Solution {

    public int minFallingPathSum(int[][] matrix) {

        int minSum = Integer.MAX_VALUE;;

        int m = matrix.length;


        int[][] dp = new int[m][m];

        for(int j = 0; j<m; j++)
            dp[0][j] = matrix[0][j];

        for(int i=1; i<m;i++)
        {
            for(int j = 0; j<m;j++)
            {
                if(j==0)
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + matrix[i][j];

                else if(j == m - 1)
                    dp[i][j] =  Math.min(dp[i-1][j-1], dp[i-1][j]) + matrix[i][j];

                else
                    dp[i][j] =  Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i-1][j+1]) + matrix[i][j];

            }
        }

        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }


        for(int i = 0; i < m; i++)
        {
            if(dp[m-1][i] < minSum)
                minSum = dp[m-1][i];
        }
        return minSum;




    }

}