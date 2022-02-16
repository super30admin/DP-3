public class minimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = (j - 1 < 0) ? Integer.MAX_VALUE : dp[i - 1][j - 1];
                int y = (j + 1 >= m) ? Integer.MAX_VALUE : dp[i - 1][j + 1];
                int z = dp[i - 1][j];

                dp[i][j] = Math.min(x, Math.min(y, z)) + matrix[i][j];
            }
        }

        int result = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            result = Math.min(result, dp[n - 1][j]);
        }

        return result;

    }
}
