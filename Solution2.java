// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

class Solution2 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j];
            }
        }
        for(int i = n-2; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = dp[i][j] + helper(dp, i, j);
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            result = Math.min(result, dp[0][i]);
        }
        return result;
    }

    private int helper(int[][] matrix, int i, int j) {
        int n = matrix.length;
        int min = matrix[i+1][j];
        if( j-1 >= 0) {
            min = Math.min(min, matrix[i+1][j-1]);
        }
        if( j+1 < n) {
            min = Math.min(min, matrix[i+1][j+1]);
        }
        return min;
    }
}