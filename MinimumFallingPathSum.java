class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        int[][] dp = new int[len][len];
        
        for(int j=0;j<len;j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1;i<len;i++){
            for(int j=0;j<len;j++){
                if(j==0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j] , dp[i-1][j+1]);
                }
                if(j==len-1){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j] , dp[i-1][j-1]);
                }
                if(j>0 && j<len-1){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j] , Math.min(dp[i-1][j+1],dp[i-1][j-1]));
                }
            }
        }

        int minimum = Integer.MAX_VALUE;
        for(int j=0;j<len;j++){
            minimum = Math.min(minimum,dp[len-1][j]);
        }
        return minimum;
    }
}