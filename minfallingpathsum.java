//Time Complexity: O(m*n) row * col
// Space Complexity:O(m) row
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //base case of 1 length
        int min = Integer.MAX_VALUE;
        if(matrix.length == 1){
            for(int i=0;i<matrix[0].length;i++){
                min = Math.min(min, matrix[0][i]);
            }
        }
        for(int i=matrix.length-2;i>=0;i--) {
            for(int j=0; j< matrix[0].length; j++){
                if(j>0 && j<matrix[0].length-1){
                    matrix[i][j] += Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1],matrix[i+1][j+1])); 
                } else if(j>0){
                    matrix[i][j] += Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }else{
                    matrix[i][j] += Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }
                if(i==0){
                    min = Math.min(min, matrix[i][j]);
                }
            }
        }
        return min;
    }
}