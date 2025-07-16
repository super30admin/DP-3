//Time Complexity: O(n^2) - where n is the number of rows (or columns) in the square matrix.
//Space Complexity: O(n) - A single dp[] array of size n is used to store values for the current row.

//Initialize a 1D dp[] array with the first row of the matrix (base case).
//For each row from top to bottom, update each column in dp[] by choosing the minimum from the cell directly above, above-left, or above-right.
//After processing all rows, return the minimum value from the last updated dp[] as the result.

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int size = matrix.length;
        int minSum = Integer.MAX_VALUE;

        int[] dp = new int[size];
        for (int col = 0; col < size; col++) {
            dp[col] = matrix[0][col]; // Initialize with first row
        }

        for (int row = 1; row < size; row++) {
            int upperLeft = dp[0];
            for (int col = 0; col < size; col++) {
                int prevValue = dp[col];
                if (col == 0) {
                    dp[col] = matrix[row][col] + Math.min(dp[col], dp[col + 1]);
                } else if (col == size - 1) {
                    dp[col] = matrix[row][col] + Math.min(upperLeft, dp[col]);
                } else {
                    dp[col] = matrix[row][col] + Math.min(Math.min(upperLeft, dp[col]), dp[col + 1]);
                }
                upperLeft = prevValue;
            }
        }

        for (int val : dp) {
            minSum = Math.min(minSum, val);
        }

        return minSum;
    }
}
