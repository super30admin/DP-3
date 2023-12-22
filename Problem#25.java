// MINIMUM FALLING PATH SUM

// Time Complexity : O(mn), where m is the number of rows and n is the number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = rows - 2; i >= 0; i--){
            for(int j = 0; j < cols; j++){
                if(j == 0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                } else if(j == cols - 1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1], matrix[i+1][j]);
                } else {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j], matrix[i+1][j+1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int j = 0; j < cols; j++){
            min = Math.min(min, matrix[0][j]);
        }
        return min;
    }
}