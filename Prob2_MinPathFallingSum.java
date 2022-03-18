// Time Complexity :  O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Using Bottom-Up Approach,

For each row, we will choose min from 3 values, belowest/Left-down diagonal and Right-down diagonal

At last, min from first row will be minFalling path sum.


*/
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        
         for(int i = matrix.length - 2; i >= 0; i--){
             for(int j = 0; j < matrix[0].length; j++){
                 if(j == 0) {
                     matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                 }    
                 else if(j == matrix[0].length - 1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]); 
                 }     
                 else  {
                     matrix[i][j] = matrix[i][j] + Math.min( matrix[i+1][j], Math.min( matrix[i+1][j+1], matrix[i+1][j-1] ));
                 }
             }
         }
         int minVal = Integer.MAX_VALUE;
         for(int p = 0; p< matrix[0].length; p++){
             minVal = Math.min(minVal, matrix[0][p]);
         }
         return minVal;
    }
}


