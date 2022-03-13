// Time Complexity : O(mn)
// Space Complexity : (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinimumFalling {
    public int minFallingPathSum(int[][] matrix) {
      
        // Paint House pattern but with mxn matrix
        for(int i = matrix.length - 2; i >= 0; i--){
            for(int j=0; j < matrix[0].length; j++){
                if(j==0){
                    matrix[i][j] = Math.min(matrix[i+1][0]+matrix[i][j],matrix[i+1][j+1]+matrix[i][j]);
                }else if(j==matrix[0].length-1){
                    matrix[i][j] = Math.min(matrix[i+1][j-1]+matrix[i][j],matrix[i+1][j]+matrix[i][j]);
                }else{
                    matrix[i][j] = Math.min(matrix[i+1][j-1]+matrix[i][j],Math.min(matrix[i+1][j]+matrix[i][j], matrix[i+1][j+1]+matrix[i][j]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i =0; i < matrix[0].length; i++){
            if(matrix[0][i]<min){
                min = matrix[0][i];
            }
        }
        return min;
    }
}
