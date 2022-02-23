// Time Complexity : O(n*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for(int i=matrix.length-1;i>=0;i--){
            for(int j=0;j<matrix[0].length;j++){
                if(i==matrix.length-1){
                    matrix[i][j] = matrix[i][j];
                }
                else{
                    if(j==0){
                       matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j+1]); 
                    }
                    else if(j==matrix[0].length-1){
                       matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1],matrix[i+1][j]);  
                    }
                    else{
                        matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1],matrix[i+1][j+1]));
                    }
                }
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            if(min>matrix[0][i]){
                min = matrix[0][i];
            }
        }
        return min;
    }
}