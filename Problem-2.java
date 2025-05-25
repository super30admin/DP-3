/**
 * Approach:
 * - Use top-down Dynamic Programming (recursion + memoization) to compute the minimum falling path sum.
 * - From each cell in the top row, recursively try all three valid moves: straight down, down-left, and down-right.
 * - Use a memoization table `dp[row][col]` to store results of subproblems to avoid recomputation.
 * - Base case: If we reach the last row, return the value at that cell.
 * - For each cell, store the minimum of the three possible paths in `dp[row][col]` and return it.
 * - Final answer is the minimum of all possible paths starting from the top row.
 */
// Time Complexity : O(N^2), where N is the number of rows (since each cell is visited only once)
// Space Complexity : O(N^2) for the `dp` array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {
    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        if (m == 1 || n == 1) return A[0][0];
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE); // Initialize memo table
        }
        int ans = Integer.MAX_VALUE;
        // Try starting from every column in the first row
        for (int i = 0; i < A.length; ++i) {
            ans = Math.min(ans, minFallingPathSum(A, 0, i, dp));
        }
        return ans;
    }

    // Recursive helper with memoization
    private int minFallingPathSum(int[][] A, int row, int col, int[][] dp) {
        int m = A.length;
        int n = A[0].length;
        // Return cached result if already computed
        if (dp[row][col] != Integer.MAX_VALUE) return dp[row][col];
        // Base case: last row
        if (row == m - 1)
            return dp[row][col] = A[row][col];
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        // Try moving to next row, left-diagonal
        if (col > 0)
            left = minFallingPathSum(A, row + 1, col - 1, dp);
        // Try moving straight down
        int straight = minFallingPathSum(A, row + 1, col, dp);
        // Try moving to next row, right-diagonal
        if (col < n - 1)
            right = minFallingPathSum(A, row + 1, col + 1, dp);
        // Store result: min of 3 possible paths + current cell value
        dp[row][col] = Math.min(left, Math.min(straight, right)) + A[row][col];
        return dp[row][col];
    }
}
