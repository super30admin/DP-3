Time Complexity-O(m*n)
Space Complexity-O(m*n)

class Solution {
    public int minFallingPathSum(int[][] A) {
     int min=Integer.MAX_VALUE;
      int n=A.length;
     int dp[][]=new int[n][n];
     for(int i=0;i<dp[0].length;i++)
     {
         dp[0][i]=A[0][i];
     }
         
        for(int i=1;i<A.length;i++)
        {
            for(int j=0;j<A[0].length;j++)
            {
            if(j==0)
                dp[i][j]=A[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
            else if(j==A.length-1)
                dp[i][j]=A[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
                else
               dp[i][j]=A[i][j]+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1]));
        
            }
        }
        
         for(int i=0;i<dp[0].length;i++)
         {
             if(dp[n-1][i]<min)
                 min=dp[n-1][i];
          }
        return min;
            
    }
        
        
