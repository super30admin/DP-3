// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=m-2; i>=0; i--){
            for(int j=0; j<n; j++){
                //check for boundry elements
                if(j == 0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }
                else if(j == n-1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1], matrix[i+1][j]);
                }
                else{
                     matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j], matrix[i+1][j+1]));
                }
                
            }
        }
            int min = matrix[0][0];
            for(int k=1; k<n; k++){
                if(matrix[0][k] < min){
                    min = matrix[0][k];
                }
            }
        return min;
    }
}