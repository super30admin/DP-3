// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0; //null check
        int m = matrix.length; //row
        int n = matrix[0].length; //column
        
        for(int i = m - 2; i >= 0; i--){ //iterating from second last row so we can add min from last row
            for(int j = 0;j < n; j++){ //iterating from 0th column
                
                if(j == 0){ //first column
                    //adding min value from below rows and columns to current one
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]); 
                    
                }else if(j == n-1){  //last column
                    
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                    
                }else{
                    
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], Math.min(matrix[i+1][j-1], matrix[i+1][j+1]));
                    
                }
            }
        }
        
       int min = Integer.MAX_VALUE;
       for(int i = 0; i < n; i++){
           min = Math.min(min, matrix[0][i]); //finding min value from top row to retrun final output
       }                                          
        
        return min;
                                                          
    }
}