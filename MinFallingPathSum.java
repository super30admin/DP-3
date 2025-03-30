//Time Complexity: O(N^2) where N is the number of rows/columns in the matrix.
// Space Complexity: O(N^2) for the dp array used to store the minimum path sums.
// LeetCode: https://leetcode.com/problems/minimum-falling-path-sum/

/**
 * This class calculates the minimum falling path sum in a square matrix.
 * A falling path starts at any element in the first row and chooses one element from each row.
 * The next row's chosen element must be in the same column or one of the adjacent columns.
 * It uses dynamic programming to build up the solution from the top to the bottom of the matrix.
 */

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];

        // Copy the first row from matrix to dp (base case)
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Fill the dp table for the rest of the rows
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // For each cell (i, j), take the minimum from the previous row's valid positions
                int minPrevRow = dp[i - 1][j]; // directly above
                if (j > 0)
                    minPrevRow = Math.min(minPrevRow, dp[i - 1][j - 1]); // left diagonal
                if (j < n - 1)
                    minPrevRow = Math.min(minPrevRow, dp[i - 1][j + 1]);
                dp[i][j] = matrix[i][j] + minPrevRow;
            }
        }

        int minPathSum = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            minPathSum = Math.min(minPathSum, dp[n - 1][j]);
        }
        return minPathSum;
    }
}
