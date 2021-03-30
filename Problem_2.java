// Time Complexity : O(n^2) where n is number of rows or coloumns as it is a n*n matrix
// Space Complexity : O(1) as we are just modifing the given input matrix
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach
// Dynamic Programming

class Solution {
    public int minFallingPathSum(int[][] matrix) {        
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(j==0){
                    matrix[i][j]+= Math.min(matrix[i-1][j],matrix[i-1][j+1]); 
                }else if(j>0 && j<matrix[0].length-1){
                    matrix[i][j]+= Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j+1],matrix[i-1][j])); 
                }else  matrix[i][j]+= Math.min(matrix[i-1][j],matrix[i-1][j-1]);
            }
        }
        int x=Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
           x = Math.min(x, matrix[matrix.length-1][i]);
        }return x;
    }
}