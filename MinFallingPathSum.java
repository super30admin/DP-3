/*TC : O(n) where N is the number of houses
SC : O(N*N) 2d matrix
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
 */

public class MinFallingPathSum {

    /*
    The approach is very similar to the paint House problem where me create a 2d matrix and
    maintain the min Falling Sum until that element in the original matrix in the same position in the new matrix.
     */
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
