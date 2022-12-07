// Time Complexity :O(mn)
// Space Complexity :O(mn)

/*
 * here we are creating a new array and using bottom up approach we
 * calculate the minimum values of the falling path and finally return 
 * the minimum of all values in first row.
 */

class MinimumFallingPathSum{
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < n; i++) dp[m-1][i] = matrix[m-1][i];
        
        for(int i = m-2; i >= 0; i--){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
                else if(j == n-1){
                    dp[i][j] =  matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j-1]);
                }
                else{
                    dp[i][j] =  matrix[i][j] + Math.min(dp[i+1][j], Math.min(dp[i+1][j-1], dp[i+1][j+1]));
                }
            }
        }
        int minimum = dp[0][0];
        for(int i = 1; i < n; i++) minimum = Math.min(dp[0][i], minimum);
        return minimum;
    }
}