class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
            if(i==0){
                dp[i][j] = matrix[i][j];
            }
            else if(j == 0) {
                dp[i][j] = Math.min(matrix[i][j] + dp[i-1][j],
                     matrix[i][j] + dp[i-1][j+1]);   
            }
            else if(j==n-1){
                dp[i][j] = Math.min(matrix[i][j] + dp[i-1][j],
                            matrix[i][j] + dp[i-1][j-1]);   
            }
            else if(j>0 && j < n-1){
                dp[i][j] = Math.min(matrix[i][j] + dp[i-1][j],
                     Math.min(matrix[i][j] + dp[i-1][j-1],
                              matrix[i][j] + dp[i-1][j+1]));   
            }
        
            if(i==n-1){
                 min = Math.min(min,dp[i][j]);
            }
        }
        }
        return min;
    }
}
