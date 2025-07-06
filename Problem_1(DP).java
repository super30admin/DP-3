class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int n = matrix.length;
        int dp[][]= new int[n][n];

        for(int i = 0; i<n;i++)
        {
            dp[n-1][i]=matrix[n-1][i];
        }

        for(int i = n-2 ; i>=0 ;i--)
        {
           for(int j = 0;j<n;j++)
           {
            if(j==0)
            {
                dp[i][j]=matrix[i][j]+Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
            else if(j==n-1)
            {
                dp[i][j]=matrix[i][j]+Math.min(dp[i+1][j],dp[i+1][j-1]);
            }
            else
            {
                 dp[i][j]=matrix[i][j]+Math.min(dp[i+1][j],Math.min(dp[i+1][j+1],dp[i+1][j-1]));
            }
           }
        }

        for(int i=0;i<n;i++)
        {
            min = Math.min(min,dp[0][i]);
        }
        return min;
    }
}
