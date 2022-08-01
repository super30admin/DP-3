// Time Complexity :O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        if(matrix.length==1){
            for(int j=0;j<matrix[0].length;j++){
                min = Math.min(min, matrix[0][j]);
            }
            return min;
        }
        for(int i=matrix.length-2;i>=0;i--){
            for(int j=0;j<matrix[0].length;j++){
                if(j==0){
                    matrix[i][j]= matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }
               else if(j==matrix[0].length-1){
                    matrix[i][j]=matrix[i][j] + Math.min(matrix[i+1][j-1], matrix[i+1][j]);
                }
               else {
                   matrix[i][j]=matrix[i][j] + Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j],matrix[i+1][j+1]));
               }
            }
        }
         for(int j=0;j<matrix[0].length;j++){
                min = Math.min(min, matrix[0][j]);
            }
            return min;
        
    }
}
