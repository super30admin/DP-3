// Approach: DP - maintain min sum to reach each index from previous row.
// Time: O(rows * columns)
// Space: O(rows * columns) for dp
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        // Initialize first row of dp with first row of matrix
        for (int j = 0; j < columns; j ++) {
            dp[0][j] = matrix[0][j];
        }
        // Fill in min sum to traverse through each path in the next rows
        for (int i = 1; i < rows; i ++) {
            for (int j = 0; j < columns; j ++) {
                dp[i][j] += matrix[i][j];
                int min = dp[i - 1][j];
                if (j - 1 >= 0) {
                    min = Math.min(min, dp[i - 1][j - 1]);
                }
                if (j + 1 < columns) {
                    min = Math.min(min, dp[i - 1][j + 1]);
                }
                dp[i][j] += min;
            }
        }
        // Find min in last row of dp
        int lastRow = rows - 1;
        int minSum = dp[lastRow][0];
        for (int col = 1; col < columns; col ++) {
            minSum = Math.min(minSum, dp[lastRow][col]);
        }
        return minSum;
    }
}