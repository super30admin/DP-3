// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Yes(Index out of bound


// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0 || A[0].length == 0) return 0;
        int rows = A.length;
        int cols = A.length;
        int[][] dp = new int[rows][cols];
        for(int col = 0; col < cols; col++){
            dp[0][col] = A[0][col];
        }
        for(int i = 1; i<rows; i++){
            for(int j = 0; j < cols;j++){
                //if( j == 0)
             {
                dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1]) + A[i][j];
             }
                if(j == cols-1){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1])+A[i][j];
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]), dp[i-1][j+1]) + A[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int x:dp[rows-1]){
            min = Math.min(x,min);
        }
        return min;
    }
}
