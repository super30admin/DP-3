// Time Complexity : O(n^2) ; we visit each cell once
// Space Complexity: O(1)   ; we modify the input matrix in-place, no extra DP table
// Did this code successfully run on Leetcode? : Yes
// Any problem you faced while coding this : No

// Approach:
// 1. We start from the second-last row and move upward.
// 2. For each cell, choose the smallest of its possible next-step cells: directly below, below-left, below-right.
// 3. Add that smallest value to the current cell. This overwrites the cell with the minimum path sum starting there.
// 4. After finishing, the smallest value in the top row is the answer.

class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        // Edge case: only one element
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }

        // Bottom-up DP: process from bottom-2 row up to row 0
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int down = matrix[row + 1][col];
                int downLeft = (col > 0) ? matrix[row + 1][col - 1] : Integer.MAX_VALUE;
                int downRight = (col < n - 1) ? matrix[row + 1][col + 1] : Integer.MAX_VALUE;

                matrix[row][col] += Math.min(down, Math.min(downLeft, downRight));
            }
        }

        // Find smallest value in the top row
        int minSum = matrix[0][0];
        for (int col = 1; col < n; col++) {
            minSum = Math.min(minSum, matrix[0][col]);
        }

        return minSum;
    }
}
