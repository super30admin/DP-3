/*TC - O(m*n)  m - number of rows of matrix , n - number of columns inmatrix
 * SC - O(m*n)
 * Ran on leetcode yes
 * */


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int[][] dp  = new int[matrix.length+1][matrix[0].length+2];
        // 2 additional columns since we are going to inspect previous column and next column for every column in the input matrix
        
        // add zero to first row 
        for(int i = 0 ; i<dp[0].length; i++){
            dp[0][i] = 0;
        }
        
        // add additional column to  the left and  right as we are considering previous row's next and previous column elements
        for (int i = 0 ; i< dp.length; i++){
            dp[i][0] =Integer.MAX_VALUE -9999;
        }
        for (int i = 0 ; i< dp.length; i++){
            dp[i][dp[0].length-1] =Integer.MAX_VALUE -9999;
        }
        //System.out.print(Arrays.deepToString(dp));
        
        for (int i = 1; i < dp.length; i++){
            for (int j =1; j < dp[0].length-1; j++){
                dp[i][j] = matrix[i-1][j-1] + Math.min( dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]) );
            }
        }
        
         //System.out.print(Arrays.deepToString(dp));
        // find minimum most in the last row of the dp matrix
        int mini = Integer.MAX_VALUE;
        for (int i=0 ; i < dp[0].length; i++){
            mini = Math.min(mini, dp[dp.length-1][i] );
        }
   
        return mini;
    }
    
}
