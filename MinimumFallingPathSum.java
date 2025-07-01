// Time Complexity: O(n^2)
// Space Complexity: O(1) (In-place DP)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach:
// - This problem is solved using a bottom-up dynamic programming approach.
// - Starting from the second last row, for each cell, compute the minimum falling path sum
//   by considering the 3 possible paths (directly below, below-left, and below-right).
// - Update the current cell with the sum of its value and the minimum of the possible next steps.
// - Edge conditions are handled for the first and last columns since they don’t have left or right neighbors.
// - After filling the matrix from bottom to top, the minimum value from the first row will be the answer.
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //Matrix size
        int n = matrix.length;

        //Traverse through the matrix(bottom - up)
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<n; j++){
                if(j==0){
                    matrix[i][j] = matrix[i][j] +
                            Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }else if(j == n-1){
                    matrix[i][j] = matrix[i][j] +
                            Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }else{
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1],
                            Math.min(matrix[i+1][j], matrix[i+1][j+1]));
                }
            }
        }

        //Get the min value from the 1st row
        int min = Integer.MAX_VALUE;
        for(int k=0; k<n; k++){
            min = Math.min(min,matrix[0][k]);
        }

        return min;
    }
}