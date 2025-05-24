// Time Complexity: O(n²)

// Space Complexity: O(n²)

class Solution {

    int min(int a, int b, int c){
        return Math.min(a,Math.min(b,c));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int [][]dp = new int[n][n];
        for(int i=0;i<n;++i)
            dp[n-1][i] = matrix[n-1][i];
        
        for(int i=n-2;i>-1;--i){
            for(int j=0;j<n;++j){
                if(j == 0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
                else if(j == n-1){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j-1] , dp[i+1][j]);
                }
                else{
                    dp[i][j] = matrix[i][j] + min(dp[i+1][j-1] , dp[i+1][j], dp[i+1][j+1]);
                }

            }
        }
        int mini = dp[0][0];
        for(int i=0;i<n;++i)
            mini = mini > dp[0][i] ? dp[0][i] : mini;
        return mini;
    }
}
