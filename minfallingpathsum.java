// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: here as m can vary. we have used a for loop to iterate throught the col.
//first we are copying the elements from matrix to dp array
// if we are using top down keeping 1st row constant
// then we are diving them into 3 types .. if j(col)==0 i.e first col we should check exactly above and also the element one col right in the above row
// if j(m-1) last row then we are checking it with above and one step left in the above row.
// else we need to check above , above left and above right of the current index. 
//and add the min value of them to the actual value in the input array.
// the min val in the last row gives the min falling path sum.


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null ) return -1;
        if(matrix.length==1 && matrix[0].length ==1 ) return matrix[0][0];
        int i=0,j=0;
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[m][n];

       // for(i=n-1;i>=0;i--)
       for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                dp[i][j]= matrix[i][j];
            }
        }

        // for(i=n-2;i>=0;i--)
        // {
        //     for(j=0;j<m;j++)
        //     {
        //         if(j==0)
        //         {
        //             dp[i][j]= matrix[i][j] + Math.min(dp[i+1][j],dp[i+1][j+1]);
        //         }
        //         else if(j== m-1)
        //         {
        //             dp[i][j]= matrix[i][j] + Math.min(dp[i+1][j],dp[i+1][j-1]);
        //         }
        //         else {
        //              dp[i][j]= matrix[i][j] + Math.min(dp[i+1][j+1], Math.min(dp[i+1][j],dp[i+1][j-1]));  
        //         }
        //     }
        // }
        // int min =11111;
        // for(i=0;i<m;i++)
        // {
        //     if(dp[0][i]< min) 
        //         min= dp[0][i];
        // }
        // return min;


        for(i=1;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(j==0)
                {
                    dp[i][j]= matrix[i][j] + Math.min(dp[i-1][j],dp[i-1][j+1]);
                }
                else if(j== m-1)
                {
                    dp[i][j]= matrix[i][j] + Math.min(dp[i-1][j],dp[i-1][j-1]);
                }
                else {
                     dp[i][j]= matrix[i][j] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i-1][j+1]));  
                }
            }
        }
        int min =11111;
        for(i=0;i<m;i++)
        {
            if(dp[m-1][i]< min) 
                min= dp[m-1][i];
        }
        return min;
    }
}