public class MinFallingPathSum {
    /**
     * 2D tabulation DP solution where we calculate the min sum starting from bottom towards top
     * considering left, center and right element of previous DP calculation at below row.
     * return minimum value from the top row of the DP array as result.
     *
     * Time: O(n^2) Space: O(n^2)
     */
    public int minFallingPathSum1(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }

        int result = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        dp[n - 1] = matrix[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] + getMinFromBelow1(matrix, dp, i + 1, j);

                if (i == 0) { //processing last level/top row in matrix
                    result = Math.min(result, dp[i][j]);
                }
            }
        }
        return result;
    }

    private int getMinFromBelow1(int[][] matrix, int[][] dp, int row, int column) {
        int min = Integer.MAX_VALUE;

        for (int j = column - 1; j <= column + 1; j++) {
            if (j < 0 || j >= dp[row].length) {
                continue;
            }
            min = Math.min(min, dp[row][j]);
        }
        return min;
    }

    /**
     * Improved space complexity through 1D tabulation DP solution as we only need numbers
     * from row below and manage the overridden 1 cell/element (which holds value for
     * diagonal left in below row) through a variable
     *
     * Time: O(n^2) Space: O(n)
     */
    int[] dp;
    public int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }

        int result = Integer.MAX_VALUE;
        this.dp = new int[n];
        this.dp = matrix[n - 1];
        int oldVal = dp[0];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int temp = dp[j];
                dp[j] = matrix[i][j] + getMinFromBelow2(matrix, oldVal, j);
                oldVal = temp;

                if (i == 0) { //processing top row in matrix
                    result = Math.min(result, dp[j]);
                }
            }
        }
        return result;
    }

    private int getMinFromBelow2(int[][] matrix, int oldVal, int column) {
        int min = Integer.MAX_VALUE;

        min = Math.min(min, dp[column]);

        if (column != 0) {
            min = Math.min(min, oldVal);
        }

        if (column + 1 < dp.length) {
            min = Math.min(min, dp[column + 1]);
        }

        return min;
    }
}
