// Time Complexity : O(n*n)
// Space Complexity : O(n) 

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int dp[][] = new int[2][c];

        if(r==1)
            return matrix[0][0];

        for(int i=0;i<c;i++)
            dp[0][i] = matrix[0][i];

        for(int i=1;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                int tempMin = dp[0][j];
                if(j-1>=0 && dp[0][j-1]<tempMin)
                    tempMin = dp[0][j-1];
                if(j+1<c && dp[0][j+1]<tempMin)
                    tempMin = dp[0][j+1];
                dp[1][j]= matrix[i][j]+tempMin;
            }
            for(int k=0;k<c;k++)
                dp[0][k] = dp[1][k];
        }

        for(int i=0; i<c; i++)
        {
            if(dp[1][i]<min)
                min = dp[1][i];
        }
        return min;
    }
}