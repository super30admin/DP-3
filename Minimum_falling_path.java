class Solution {
    public int minFallingPathSum(int[][] A) {
        
        int m = A.length;
        int n = A[0].length;
        
        int[][] dp = new int[m][n];
        
        for(int j=0; j<n ; j++){
            dp[0][j] = A[0][j];
        }
        
        for(int i = 1; i< m ; i++){
            for(int j=0; j < n; j++){
                
                if(j==0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1])+A[i][j];
                }
                else if(j==n-1){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1])+A[i][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i-1][j+1]))+A[i][j];
                                        
                }
            }
        
        }
        int min=dp[m-1][0];
        for(int j=0; j < n ;j++  ) {
            if(dp[m-1][j] < min){
                min = dp[m-1][j];
            }
        }
    return min;
}
}