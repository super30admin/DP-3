
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// We fill the first row of the dp array with the values from the first row of the matrix.
// Then, for each cell (i,j) in the matrix, we calculate the minimum falling path sum to reach that cell by considering the
// cells directly above it, as well as the cells diagonally above it to the left and right.
// Finally, we find the minimum value in the last row of the dp array, which represents the minimum falling path sum for the entire matrix.

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length,up=0,leftdia=0,rightdia=0;
        int dp[][]=new int[n][n];

        for(int i=0;i<n;i++)
            dp[0][i]=matrix[0][i];

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                up=dp[i-1][j];
                if(j>0)
                    leftdia=dp[i-1][j-1];
                else
                    leftdia=Integer.MAX_VALUE;  // If we're at the left edge, there's no left diagonal
                if(j<n-1)
                    rightdia=dp[i-1][j+1];
                else
                    rightdia=Integer.MAX_VALUE;  // If we're at the right edge, there's no right diagonal

                // The current cell's value is added to the minimum of the three possible paths
                dp[i][j]=matrix[i][j]+Math.min(up,Math.min(leftdia,rightdia));
            }
        }
        int min=Integer.MAX_VALUE;
        for (int j=0;j<n;j++) {
            min=Math.min(min,dp[n-1][j]);
        }
        return min;
    }
}