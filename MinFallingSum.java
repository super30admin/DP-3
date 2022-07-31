// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        // dp matrix
        int[][] dp = new int[n][n];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
            //if i == 0 so its a first row, put the first row of matrix in dp first row
            if(i==0){
                dp[i][j] = matrix[i][j];
            }
            //if j == 0 so its a first element in that row so we should only check the one aboue and the one above on right
            else if(j == 0) {
                dp[i][j] = Math.min(matrix[i][j] + dp[i-1][j],
                     matrix[i][j] + dp[i-1][j+1]);   
            }
            //if j == n-1 so its a last element in that row so we should only check the one aboue and the one above on left
            else if(j==n-1){
                dp[i][j] = Math.min(matrix[i][j] + dp[i-1][j],
                            matrix[i][j] + dp[i-1][j-1]);   
            }
            //if j>0 && j < n-1 so its not first or element in that row so we should check the one aboue,the one above on left and the one above on right
            else if(j>0 && j < n-1){
                dp[i][j] = Math.min(matrix[i][j] + dp[i-1][j],
                     Math.min(matrix[i][j] + dp[i-1][j-1],
                              matrix[i][j] + dp[i-1][j+1]));   
            }
            
            //since we want min, maintain min during the last row iteration
            if(i==n-1){
                 min = Math.min(min,dp[i][j]);
            }
        }
        }
        return min;
    }
}
