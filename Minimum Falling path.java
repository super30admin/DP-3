// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Firstly I have created a 2D matrix and followed a bottom up approach. I have filled the dp matrix will the last row of the given matrix. Then found minimum of the direct neighbors of the element and stored it in the dp. In the end the first row of the dp matrix will have all the final element and then I have found the minimum in that row.
//I have further optimized this 2D Array into 1 D Array

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int m=matrix.length,n=matrix[0].length;
        int min =Integer.MAX_VALUE;
        int[]dp=new int [n];
        dp[n-1]=matrix[m-1][n-1];
for(int j=0;j<n;j++)
{
      dp[j]=matrix[m-1][j];
      System.out.println("dp[" + j + "]=" + dp[j]);

}
    for(int i=m-2;i>=0;i--)
    {
        int []temp=new int[n];
       for(int j=0;j<n;j++)
       {
           //left element
            if(j==0)
            {
                temp[j]=matrix[i][j] + Math.min(dp[j],dp[j+1]);
                System.out.println("dp[" + j + "]=" + dp[j]);
            }
            //right element
            else if(j==n-1)
            {

                temp[j]=matrix[i][j] + Math.min(dp[j-1],dp[j]);
                System.out.println("dp[" + j + "]=" + dp[j]);
            }
            //middle element
            else
            {
                temp[j]=matrix[i][j] + Math.min(dp[j-1],Math.min(dp[j],dp[j+1]));
                System.out.println("dp[" + j + "]=" + dp[j]);
            }  
       }
       dp=temp;
    }
    for(int i=0;i<n;i++)
    {
        if (dp[i]<min)
        {
            min=dp[i];
        }
    }
    return min;

    }
}




/* 

2-D Array
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int m=matrix.length,n=matrix[0].length;
        int min =Integer.MAX_VALUE;
        int[][] dp=new int [m][n];
        dp[m-1][n-1]=matrix[m-1][n-1];

//filling the last row of the dp matrix with the elements of matrix array.
for(int j=0;j<n;j++)
{
      dp[m-1][j]=matrix[m-1][j];

}

//We will have a bottom up approach, so we will find the minimum from the possible paths and add it to the current element.
    for(int i=m-2;i>=0;i--)
    {
       for(int j=0;j<n;j++)
       {
           //left element
            if(j==0)
            {
                dp[i][j]=matrix[i][j] + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
            //right element
            else if(j==n-1)
            {
                dp[i][j]=matrix[i][j] + Math.min(dp[i+1][j-1],dp[i+1][j]);
            }
            //middle element
            else
            {
                dp[i][j]=matrix[i][j] + Math.min(dp[i+1][j-1],Math.min(dp[i+1][j],dp[i+1][j+1]));
            }
   // int mx=m-1;
System.out.println("dp[" + i + "][" + j + "]=" + dp[i][j]);
           
       }
    }

//Minimum element can be found in the first row of the array
    for(int i=0;i<n;i++)
    {
        if (dp[0][i]<min)
        {
            min=dp[0][i];
        }
    }
    return min;

    }
}

*/