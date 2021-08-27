// Time Complexity : O(m x n) where m is rows and n is columns in matrix
// Space Complexity : O(m x n) where m is rows and n is columns in matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        //null case
        if(matrix == null || matrix.length == 0) return 0;
        
        //declare the dp array to store
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        //fill up the first row of dp as it is in matrix
        for(int i = 0; i< dp.length; i++) {
            dp[0][i] = matrix[0][i];
        }
        
        //further rows to be filled with best possible combination (min)
        for(int i = 1; i< dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if( (j-1 >= 0) && (j+1 < dp[0].length) ) { //left diagonal & right diagonal existance check
                    //min of 3 cases
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], 
                                        Math.min(dp[i-1][j-1], dp[i-1][j+1]));
                }
                else if( (j-1 < 0) && (j+1 < dp[0].length) ) { //left diagonal not present BUT right diagonal exists
                    //min of 2 cases (including right upper diagonal)
                    dp[i][j] = matrix[i][j] + Math.min( dp[i-1][j], dp[i-1][j+1] );
                }
                else if( (j+1 >= dp[0].length) && (j-1 >= 0) ) { //right diagonal not present BUT left diagonal exists
                    //min of 2 cases (including left upper diagonal)
                    dp[i][j] = matrix[i][j] + Math.min( dp[i-1][j], dp[i-1][j-1] );
                }
                else {
                    dp[i][j] = matrix[i][j] + dp[i-1][j];
                }
                
            }
        }
        
        
        int genmin = Integer.MAX_VALUE;
        for(int k = 0; k < dp[0].length; k++) {
            genmin = Math.min( genmin, dp[dp.length - 1][k] );
        }
        return genmin;
    }
}