class Solution {
    /*
     * Time Complexity - O(n^2) 
     * Space Complexity - O(n^2)
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int j=0; j<n; j++)
            dp[n-1][j] = matrix[n-1][j];
        for (int i=n-2; i>=0; i--) {
            for (int j=0; j<n; j++) {
                // handle case where j is 0, find min between (row+1, col) and (row+1, col+1)
                if (j==0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
                // handle case where j is n-1, find min between (row+1, col-1) and (row+1, col)
                else if (j==n-1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j-1], dp[i+1][j]);
                }
                // Otherwise, find min between (row+1, col-1), (row+1, col), (row+1, col+1)
                else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j-1], Math.min(dp[i+1][j], dp[i+1][j+1])); 
                }
                
            }
        }

        // Find min between first row column values
        int min = Integer.MAX_VALUE;
        for (int j=0; j<n; j++) {
            if (min>dp[0][j])
                min = dp[0][j];
        }
        return min;
    }
}