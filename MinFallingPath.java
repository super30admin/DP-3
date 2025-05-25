// Time Complexity O(m*n)
// Space Complexity O(m*n)
// Runs on LeetCode YES

class MinFallingPath {
    public int minFallingPathSum(int[][] matrix) {
        int cols = matrix.length;
        int rows = matrix.length;
        int[][] dp = new int[rows][cols];

        for (int j = 0; j < cols; j++) {
            dp[rows - 1][j] = matrix[rows - 1][j];
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    int bottomRight = dp[i + 1][j + 1];
                    int bottom = dp[i + 1][j];
                    dp[i][j] = Math.min(matrix[i][j] + bottomRight, matrix[i][j] + bottom);

                } else if (j == cols - 1) {
                    int bottomLeft = dp[i + 1][j - 1];
                    int bottom = dp[i + 1][j];
                    dp[i][j] = Math.min(matrix[i][j] + bottomLeft, matrix[i][j] + bottom);
                } else {
                    int bottomLeft = dp[i + 1][j - 1];
                    int bottomRight = dp[i + 1][j + 1];
                    int bottom = dp[i + 1][j];
                    dp[i][j] = Math.min(Math.min(matrix[i][j] + bottomLeft, matrix[i][j] + bottomRight),
                            matrix[i][j] + bottom);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < cols; j++) {
            result = Math.min(result, dp[0][j]);
        }
        return result;
    }
}
