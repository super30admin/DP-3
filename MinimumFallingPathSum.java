// Time Complexity :O(n*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(j == 0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                }
                else if(j == matrix.length - 1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                }
                else{
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i -1][j], Math.min(matrix[i - 1][j + 1], matrix[i - 1][j - 1]));
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < matrix.length; i++){
            min = Math.min(min, matrix[matrix.length - 1][i]);
        }
        
        return min;
    }
}
