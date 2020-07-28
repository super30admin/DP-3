//Time complexity=O(M*N), Size of matrix as we are travirsing the entire matrix
//Space Complexity=O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Here we are creating a matrix to store the value of minimum path upto that point in the matrix. To do so we are choosing the minimum of the previous sum, and at last we are finding the minimum of the last row in the matrix which we created. 
class Solution {
    public int minFallingPathSum(int[][] A) {
        int[][] dp=new int[A.length][A[0].length];
        for(int i=0;i<A.length;i++)
        {
            dp[0][i]=A[0][i];//We are storing the 1st row value as it is from the given matrix, as it is their sum for that point
        }
        for(int i=1;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(j==0)//For the 1st column of the matrix as it doesn't have any element to left of it.
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j+1])+A[i][j];
                else if(j>=A.length-1)//For the right most column of the matrix
                {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+A[i][j];
                }
                else //For the elements except the right most and left most
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1]))+A[i][j];
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++)
        {
            min=Math.min(min,dp[A.length-1][i]);//Choosing the minimum value from the last row
        }
        return min;
    }
}