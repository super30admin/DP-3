// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        // find number of rows in the square matrix (rows == columns) 
        int n = matrix.length;
                
        // intialize dp matrix of n X n 
        int [][] dp = new int[n][n];
        
        // intitialize min
        int min = Integer.MAX_VALUE;
       
        // fill the first row of dp matrix as it is in the given matrix
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }
        
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                
                // in case of 0th col, only consider the element exactly above
                // and element above right
                if(j == 0){
                    
                    // take sum of the element with the min value between the
                    // previous elements satifying the above condition
                    
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                    
                }
                // in case of last col, only consider the element exactly above
                // and element above left
                
                else if(j == n - 1){
                
                    // take sum of the element with the min value between the
                    // previous elements satifying the above condition
                    
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);

                }
                
                // else consider the elements exactly above, left above and right above
                else{
                    
                    // take sum of the element with the min value between the
                    // previous elements satifying the above condition    
                    
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
                
                }
            }
        }
        
        // return the minimum value from the last row
        for(int i = 0; i < n; i++){
    
            min = Math.min(min, dp[n - 1][i]);            
        }
        
        return min;
    }
}
