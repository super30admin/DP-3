/*
 * Time Complexity - Recursive with memoization: O(n * m), where n = number of rows, m = number of columns
 * Time Complexity - DP: O(n * m), since each cell is computed once
 *
 * Space Complexity - Recursive: O(n * m) for memo map + O(n) recursion stack
 * Space Complexity - DP: O(n * m) for the dp table
 *
 * Approach -
 * Recursive with Memoization:
 * - Starting from each cell in the top row, I recursively try to go down, down-left, and down-right.
 * - At each step, I store the result in a memo map to avoid recomputation.
 * - Base case: if I'm at the last row, return the matrix value itself.
 * - The final answer is the minimum of all paths starting from row 0 (across all columns).
 *
 * DP:
 * - I create a 2D dp table where dp[i][j] stores the minimum path sum to reach cell (i,j).
 * - Base case: first row of dp is same as matrix (no previous row to compute from).
 * - For each dp[i][j], I calculate minimum from:
 *     - dp[i-1][j]   → directly above
 *     - dp[i-1][j-1] → diagonally left
 *     - dp[i-1][j+1] → diagonally right
 * - Final answer is the minimum value in the last row of dp.
 */

import java.util.HashMap;
import java.util.Map;

public class Problem_2 {
    static int ROWS;
    static int COLS;
    static int[][] matrix;
    static Map<String, Integer> memo = new HashMap<>();

    public static int minFallingPathSum_dp(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int[][] dp = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                dp[i][j] = Integer.MAX_VALUE - 10000;
            }
        }
        for (int j = 0; j < COLS; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                int left = Integer.MAX_VALUE - 10000;
                int up = Integer.MAX_VALUE - 10000;
                int right = Integer.MAX_VALUE - 10000;
                if ((i - 1 >= 0) && (j < COLS)) {
                    up = matrix[i][j] + dp[i - 1][j];
                }
                if ((i - 1 >= 0) && (j - 1 >= 0)) {
                    left = matrix[i][j] + dp[i - 1][j - 1];
                }
                if ((i - 1 >= 0) && (j + 1 < COLS)) {
                    right = matrix[i][j] + dp[i - 1][j + 1];
                }
                dp[i][j] = Math.min(up, Math.min(left, right));
            }
        }
        int res = Integer.MAX_VALUE;
        for (int k = 0; k < COLS; k++) {
            res = Math.min(res, dp[ROWS - 1][k]);
        }
        return res;
    }

    public static int minFallingPathSum_recursive(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        Problem_2.matrix = grid;
        int res = Integer.MAX_VALUE - 10000;
        for (int i = 0; i < ROWS; i++) {
            res = Math.min(res, dfs(0, i));
        }
        return res;
    }

    private static int dfs(int r, int c) {
        if (r == ROWS - 1) {
            return matrix[r][c];
        }
        if ((r >= ROWS) || (c >= COLS)) {
            return Integer.MAX_VALUE - 10000;
        }
        String key = Integer.toString(r) + ',' + Integer.toString(c);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int left = Integer.MAX_VALUE - 10000;
        int down = Integer.MAX_VALUE - 10000;
        int right = Integer.MAX_VALUE - 10000;
        if ((r + 1 < ROWS) && (c < COLS)) {
            down = matrix[r][c] + dfs(r + 1, c);
        }
        if ((r + 1 < ROWS) && (c - 1 >= 0)) {
            left = matrix[r][c] + dfs(r + 1, c - 1);
        }
        if ((r + 1 < ROWS) && (c + 1 < COLS)) {
            right = matrix[r][c] + dfs(r + 1, c + 1);
        }
        memo.put(key, Math.min(left, Math.min(down, right)));
        return memo.get(key);
    }

    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        System.out.println(minFallingPathSum_recursive(matrix));
        System.out.println(minFallingPathSum_dp(matrix));
    }

}
