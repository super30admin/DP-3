// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int minFallingPathSum(int[][] A) {
        
        if(A.length==0 || A == null)
            return 0;
        
        int rows =A.length;
        int cols = A.length;
        
        int[][] dp = new int[A.length][A.length];
        for(int i=0;i<cols;i++)
        {
            dp[0][i]=A[0][i]; 
        }
        
        
        for(int i=1;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                dp[i][j] = A[i][j]+ Math.min(Math.min(dp[i-1][Math.max(0,j-1)],dp[i-1][j]),dp[i-1][Math.min(j+1,cols-1)]);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int x:dp[rows-1])
        {
            min = Math.min(x,min);
        }
        return min;
    }
}