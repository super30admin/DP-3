public class MinFallingPath {

    // ## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
    // Time Complexity : O(n ^ 2)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : I didnt face any problem while coding this
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<n; j++){
                if(j == 0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j],dp[i+1][j+1]);
                }
                else if(j == n-1){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j],dp[i+1][j-1]);
                }else{
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j],Math.min(dp[i+1][j+1],dp[i+1][j-1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < matrix.length; j++) {
            min = Math.min(min, dp[0][j]);
        }
        return min;
    }
}
