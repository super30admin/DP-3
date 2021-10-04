//time complesity : O(n*m)
//space complexity : O(n)

class Solution {
    public int minFallingPathSum(int[][] matrix) {

        if(nums.length == 0){
            return 0;
        }

        int n = matrix.length;
        int m = matrix.length[0];

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }

        for( int i = 1; i < n ; i++){
            for( int j = 0; j < m; j++){
                if(j == 0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j],dp[i - 1][j + 1]);

                }
                else if(j == n-1){
                    dp[i][j] = matrix [i][j] + Math.min(dp[i - 1][j],dp[i - 1][j - 1]);

                }
                else{
                    dp[i][j] = matrix [i][j] + Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j],dp[i - 1][j + 1]));

                }
            }
        }
    }
}
