public class MinimumFallingPathSum {
    // TC: O(M*N) where M is the number of rows and N is number of cols in matrix
    // SC: O(M*N) where M is the number of rows and N is number of cols in matrix
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = dp[i-1][j];
                int topLeft = j == 0 ? Integer.MAX_VALUE : dp[i - 1][j - 1];
                int topRight = j == n - 1 ? Integer.MAX_VALUE : dp[i - 1][j + 1];
                int min = Math.min(top, Math.min(topLeft, topRight));
                dp[i][j] = min + matrix[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp[m - 1][j]);
        }
        return res;
    }
}
