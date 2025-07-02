// Time Complexity : O(n^2) -> since we are iterating over each element of n X n matrix
// Space Complexity : O(1) -> we are mutating the original matrix, no additional space is required.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
    //None

// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        //base case
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int n = matrix.length;

        //mutating the original matrix to save on space
        //start from the second last column -> n - 2 and work your way up
        
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j < n; j++){

                if(j == 0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }
                else if( j == n - 1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }
                else{
                    matrix[i][j] = matrix[i][j] + Math.min(
                        matrix[i+1][j], 
                        Math.min(matrix[i+1][j+1], matrix[i+1][j-1]) 
                    );
                }

            }
        }

        //iterate to get the min value from the first row and return it.
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            min = Math.min(min, matrix[0][i]);
        }

        return min;


    }
}