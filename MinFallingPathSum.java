/**
## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
 
Time Complexity :   O (N^2) 
Space Complexity :  O (N^2) 
Did this code successfully run on Leetcode :    Yes (931. Minimum Falling Path Sum)
Any problem you faced while coding this :       No
 */

 class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        if ( matrix == null || matrix.length == 0 )
            return 0;
        
        int m = matrix.length;         // rows
        int n = matrix[0].length;      // columns
        int[][] dp = new int[m + 1][n+1];
        
        // copy the last row 
        for( int col = 0; col < n; col++){
            dp[n-1][col] = matrix[n-1][col];
        }
        
        // add current value + min value of other 2 rows
        for( int row = m-1; row >= 0; row--){
            for( int col = 0; col < n; col++){
                if(col == 0){
                    dp[row][col] = matrix[row][col] + Math.min(dp[row+1][col], dp[row+1][col + 1]);
                }else if(col == m -1){
                    dp[row][col] = matrix[row][col] + Math.min(dp[row+1][col], dp[row+1][col-1]);
                }else{
                    dp[row][col] = matrix[row][col] + Math.min( dp[row+1][col], Math.min(dp[row+1][col - 1], dp[row+1][col + 1]));
                }
            }
            
        }
        
        // return min from all columns from 1st row
        int minFallingSum = Integer.MAX_VALUE;
        for (int start = 0; start < matrix.length; start++) {
            minFallingSum = Math.min(minFallingSum, dp[0][start]);
        }
        return minFallingSum;
    }
    
    public static void main(String args[]) 
    { 
        MinFallingPathSum obj = new MinFallingPathSum();
        int[][] matrix = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(obj.minFallingPathSum(matrix));
    }
}