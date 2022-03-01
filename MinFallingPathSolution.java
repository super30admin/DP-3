// Time Complexity : O(n^2 + n) = O(n^2)
// Space Complexity : O(1) // changing given matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinFallingPathSolution {
    public int minFallingPathSum(int[][] matrix) {
        int num = matrix[0].length; // number of rows and number of columns
        for (int i = 1; i < num; i++){ // iterate through number of rows, startinf from second
            for (int j = 0; j < num; j++){ // iterate through number of columns
                if (j==0){
                    matrix[i][j] += Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                }
                
                else if (j == num-1){
                    matrix[i][j] += Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                }
                else{
                    matrix[i][j] += Math.min(Math.min(matrix[i-1][j-1],matrix[i-1][j]),matrix[i-1][j+1]);
                }
            }
        } 
    
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < num; k++){
            min = Math.min(min, matrix[num-1][k]);
        }
        return min;
    }
}