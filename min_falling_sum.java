// Time Complexity : O(n ^2) : Need to traverse each element in the matrix
// Space Complexity : O( n ^ 2) : DP  2D matrix

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        // DP value : Store the sum starting with that element
        int[][] dp = new int[matrix.length][matrix.length];

        //  Initialise the last row to populate the previous rows
        for(int i = 0; i < matrix[0].length; i++)
            dp[matrix.length-1][i] = matrix[matrix.length-1][i];

            for(int i = matrix.length-2; i >= 0; i--){
                for(int j = 0; j < matrix[0].length; j++){

                    // Left most column : No need to add the j-1 element
                    if(j == 0){
                       dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + matrix[i][j];
                    }
                    
                    // Right most column : No need to add the j+1 element
                    else if(j == matrix[0].length-1){
                       dp[i][j] = Math.min(dp[i+1][j-1],dp[i+1][j]) + matrix[i][j];
                    }
                    
                    // Consider all the three elements
                    else{
                       dp[i][j] = Math.min(Math.min(dp[i+1][j-1],dp[i+1][j]),dp[i+1][j+1]) + matrix[i][j];
                    }
                }
            }

        
            // Minimum of the first row in the DP
            int min = Integer.MAX_VALUE;
            for(int i = 0; i< matrix.length ;  i++ ){
                
                min = Math.min(min,dp[0][i]);
            } 
            return min;

    }
 
}
