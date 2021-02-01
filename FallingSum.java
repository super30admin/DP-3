// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class FallingSum {
    public int minFallingPathSum(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] dp = new int[rows][cols];
        
        // initialize the 1st row
        for(int i=0; i<cols; i++) {
            dp[0][i] = matrix[0][i];
        }
        

        for(int i=1; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                
                //if 0th column, take minimum of previous row's 0th and 1st column elements
                if(j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][0], dp[i-1][1]);
                }
                
                //if last column, take minimum of previous row's last and (last-1) column elements
                else if(j == cols-1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                
                // else take minimum of previous row's j-1,0 and column elements
                } else {

                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]));
                }
                
            }
        }
        
        // return the minimum from the last row
        int min = Integer.MAX_VALUE;
        for(int i=0; i<cols; i++) {
            if(dp[rows-1][i] < min) {
                min = dp[rows-1][i];
            }
        }
        return min;
        
    }
}