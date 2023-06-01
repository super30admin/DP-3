class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp=new int[matrix.length][matrix.length];
        for(int i=0; i<matrix.length; i++)
        {
            dp[0][i]=matrix[0][i];
        }
        for(int i=1; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                if(j>0 && j<matrix.length-1)
                {
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i-1][j+1]);
                }
                else if(j==0)
                {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j],dp[i-1][j+1]);
                }
                else if(j==matrix.length-1)
                {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j],dp[i-1][j-1]);
                }
            }
        }
        int sol=100*matrix.length*matrix.length;
        for(int k=0; k<matrix.length; k++)
        {
            sol=Math.min(sol,dp[matrix.length-1][k]);
        }
        return sol;
    }
}