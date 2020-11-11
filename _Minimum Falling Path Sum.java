
// time complexity is O(n^2) and space complexity is O(n^2)
// i m getting a wrong answer from this code
// here if we are at 0th column then we will add  with the minimum of the value of 0th and next column with the current value and if column is last then we add  with the minimum of the value of last and second last column with the current value
//else we we will add  with the minimum of the value of the row just above in the same column and next and previous column values
// finally we return the min of the last row in the matrix
class Solution {
    public int minFallingPathSum(int[][] A) {
         int min=Integer.MAX_VALUE;
          int n=A[0].length;
        int [][] dp=new int[n][n];
        for(int i=0;i<n;i++)
        {
            dp[0][i]=A[0][i];
        }
        for(int i=1;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                if(j==0)
                {
                    dp[i][j]=A[i][j]+Math.min(A[i-1][j],A[i-1][j+1]);
                }
               else if(j==n-1)
                {
                    dp[i][j]=A[i][j] +Math.min(A[i-1][j],A[i-1][j-1]);
                }
                else
                    dp[i][j]=A[i][j]+Math.min(A[i-1][j],Math.min(A[i-1][j-1],A[i-1][j+1]));

            }
        }

        for(int i=0;i<n;i++)
        {
            if(dp[n-1][i]<min)
            {
                min=dp[n-1][i];
            }

        }
     return min;
    }

}
