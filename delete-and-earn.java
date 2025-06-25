//DP
//Create a 2D dp table where dp[i][j] stores the minimum path sum to reach cell (i,j).
//Base case: first row of dp is same as matrix (no previous row to compute from).
//For each dp[i][j], calculate minimum from:
//     - dp[i-1][j]   -> directly above
//     - dp[i-1][j-1] -> diagonally left
//     - dp[i-1][j+1] -> diagonally right
//Return the minimum value in the last row of dp.
// Time Complexity: O(n * m), since each cell is computed once
// Space Complexity: O(n * m) for the dp table

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = Integer.MAX_VALUE - 10000;
            }
        }
        for (int j = 0; j < cols; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = Integer.MAX_VALUE - 10000;
                int up = Integer.MAX_VALUE - 10000;
                int right = Integer.MAX_VALUE - 10000;
                if ((i - 1 >= 0) && (j < cols)) {
                    up = matrix[i][j] + dp[i - 1][j];
                }
                if ((i - 1 >= 0) && (j - 1 >= 0)) {
                    left = matrix[i][j] + dp[i - 1][j - 1];
                }
                if ((i - 1 >= 0) && (j + 1 < cols)) {
                    right = matrix[i][j] + dp[i - 1][j + 1];
                }
                dp[i][j] = Math.min(up, Math.min(left, right));
            }
        }
        int res = Integer.MAX_VALUE;
        for (int k = 0; k < cols; k++) {
            res = Math.min(res, dp[rows - 1][k]);
        }
        return res;
    }
}