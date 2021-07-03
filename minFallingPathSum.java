//time complexity O(n ^ 2) where rows = columns = n
//space complexity O(n ^ 2) where n ^ 2 is the size of dp matrix

class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0) return 0;
        int n = A.length;
        int[][] dp = new int[n][n];
        for(int j = 0; j < n; j++){
                dp[0][j] = A[0][j];
            }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == 0) dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                 else if(j == n-1) dp[i][j] = A[i][j] +  Math.min(dp[i-1][j-1], dp[i-1][j]);
                 else dp[i][j] = A[i][j] +  Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1]));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
           if(dp[n-1][j] < min){
               min = dp[n-1][j];
           };
        }
        return min;
    }
}
