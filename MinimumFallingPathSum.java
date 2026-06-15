class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<n;i++){
            dp[0][i] = grid[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i-1][j+1]);
                }else if(j==n-1){
                   dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i-1][j-1]); 
                }else{
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1]));
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            res = Math.min(res,dp[m-1][i]);
        }
        return res;
    }
}