// Time Complexity : O(nxm) n and m are dimensions of the input matrix
// Space Complexity : O(nxm)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public int minFallingPathSum(int[][] matrix) {

        if(matrix==null || matrix.length==0)
            return 0;

        int[][] dp = new int[matrix.length][matrix[0].length];

        //fill the last row of dp matrix same as input
        for(int j=0; j<matrix[0].length; j++)
        {
            dp[matrix.length-1][j] = matrix[matrix.length-1][j];
        }

        //iterate over the rows
        for(int i=matrix.length-2; i>=0; i--)
        {
            //iterate over the cols
            for(int j=0; j<matrix[0].length; j++)
            {
                //if it's the first column
                if(j==0)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);

                //if it's the last column
                else if(j==matrix[0].length-1)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j-1], dp[i+1][j]);

                else
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j-1], Math.min(dp[i+1][j], dp[i+1][j+1]));
            }
        }

        int min=Integer.MAX_VALUE;

        //answer is min from the top row
        for(int j=0; j<dp[0].length; j++)
        {
            min = Math.min(min, dp[0][j]);
        }

        return min;
    }
}
