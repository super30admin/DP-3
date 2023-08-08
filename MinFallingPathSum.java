// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*

    Approach:
    The solution uses dynamic programming to find the minimum falling path sum in the given matrix.
    Starting from the second row, it calculates the minimum path sum for each cell based on the
    values of the cells directly above and the diagonally left and right.
    The final answer is the minimum value in the last row of the dynamic programming array.


 */


import java.util.Arrays;

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // Base case: If the matrix has only one row, return the minimum value in that row
        if (n == 1) {
            return Arrays.stream(matrix[0]).min().getAsInt();
        }

        // Dynamic programming array to store the minimum falling path sum
        int[][] dp = new int[n][n];

        // Initialize the first row of the dp array with the values from the first row of the matrix
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        // Traverse through the dp array and calculate the minimum falling path sum
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int left = (j > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE; // Check the left diagonal element if available
                int up = dp[i - 1][j]; // Check the element directly above
                int right = (j < n - 1) ? dp[i - 1][j + 1] : Integer.MAX_VALUE; // Check the right diagonal element if available

                dp[i][j] = matrix[i][j] + Math.min(left, Math.min(up, right)); // Calculate the minimum falling path sum
            }
        }

        // Find the minimum value in the last row of the dp array, which represents the minimum falling path sum
        int minPathSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minPathSum = Math.min(minPathSum, dp[n - 1][i]);
        }

        return minPathSum;
    }
}
