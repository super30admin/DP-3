// Time complexity - O(n)
// Space complexity - O(n)
// Did you solve on leetcode - yes
// Did you face any Problem - No
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n]; // memoization table

        // Initialize dp with a special value (e.g., Integer.MAX_VALUE)
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int minSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, helper(matrix, 0, col, dp));
        }

        return minSum;
    }

    private int helper(int[][] matrix, int row, int col, int[][] dp) {
        int n = matrix.length;

        // Boundary check
        if (col < 0 || col >= n) return Integer.MAX_VALUE;

        // Base case: last row
        if (row == n - 1) return matrix[row][col];

        // If already computed, return the stored result
        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }

        int downLeft = helper(matrix, row + 1, col - 1, dp);
        int down = helper(matrix, row + 1, col, dp);
        int downRight = helper(matrix, row + 1, col + 1, dp);

        dp[row][col] = matrix[row][col] + Math.min(downLeft, Math.min(down, downRight));
        return dp[row][col];
    }
}
