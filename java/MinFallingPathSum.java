// Time Complexity : O(M*N) M is number of rows and N is columns
// Space Complexity : O(1) as we are mutating the input matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Bottom-up approach where we iterate each element with next row's possible elements either straight or left/right elements
All the minimum possible elements for that column would be saved in top row.
So iterate the loop for number of columns in the top row to get the min (minimum falling paths).
 */
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;

        for(int i=matrix.length-2; i>=0; i--){
            for(int j=0; j<matrix[0].length; j++){
                if(j==0){
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }
                else if(j == matrix[0].length-1){
                    matrix[i][j] += Math.min(matrix[i+1][j-1], matrix[i+1][j]);
                }
                else {
                    matrix[i][j] += Math.min(
                            matrix[i+1][j-1],
                            Math.min(matrix[i+1][j], matrix[i+1][j+1]));
                }

            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < matrix[0].length; i++)
        {
            min = Math.min(min, matrix[0][i]);
        }
        return min;
    }
}