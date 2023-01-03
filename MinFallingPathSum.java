// Time Complexity : O(n*n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Greedy approach won't always give us optimal solution here so we look to use an exhaustive approach
// Since there are repeated subproblems we can make use of DP approach. Also, since we only look at previous row at each step, we can also optimize for space.
// Repeated subproblem - Min falling path at (row, col) will depend on min of (row - 1, col - 1), (row - 1, col), or (row - 1, col + 1).

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