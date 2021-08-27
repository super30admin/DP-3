// Time Complexity: O(number of rows*number of columns) as we are traversing each value to update to sumulative minimum
// Space Complexity: O(1), we have taken only a constant to save minimum, rest manipulating original matrix 
// Did you complete it at leetcode: Yes
// Any problems faced: Completed in 1 go

// Write your approach here:
// Idea is to use the solved subproblems at the end of the matrix and calculate the minimum cumulative sum uptil 0th row
// To perform that we have kept last row unaffected and iterating from 2nd last row for every 0th index only deterministic values are row+1, same columns and row+1 and column+1, similary only 2 deterministic value for last column.
// for all others in middle used one row below's col-1, col and col+1 for falling.
// At end first row holds the sum of minimum path from each column start. We just have to loop it once to provide minimum among them.
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int leastPath = Integer.MAX_VALUE;
        for(int i=matrix.length-2; i>=0; i--) {
            for(int j = 0; j<=matrix[0].length-1; j++) {
                if(j==0) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                } else if(j== matrix[0].length-1) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1], matrix[i+1][j]);
                } else {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j], matrix[i+1][j+1]));
                }
            }
        }
        
        for(int j = 0; j<matrix[0].length; j++) {
            leastPath = Math.min(leastPath, matrix[0][j]);
        }
        return leastPath;
    }
}