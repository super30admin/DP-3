// Time Complexity : O(n^2), n -no. of rows/columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Approach:
// From second-last row update each cell with the minimum falling path sum from the row below.
// At each cell, choose the minimum among directly below, diagonally left, and diagonally right values.
// Return the minimum value from top row as result.


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0){
            return 0;
        }

        int n=matrix.length;
        for(int i=n-2;i>=0;i--)
        {
            for(int j=0;j<n;j++)
            {
                if(j==0){
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }
                else if(j==n-1){
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }
                else{
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],Math.min(matrix[i+1][j+1],matrix[i+1][j-1]));
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            min=Math.min(min,matrix[0][j]);
        }
        return min;
    }
}