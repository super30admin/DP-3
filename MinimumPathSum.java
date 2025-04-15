/*
 * Problem: Minimum Falling Path Sum (Leetcode-style)
 *
 * Idea:
 * - Start from the second-last row and move upwards.
 * - For each element, choose the minimum from the three options in the row just below:
 *     → directly below
 *     → bottom-left (if exists)
 *     → bottom-right (if exists)
 * - Keep updating the current cell with the sum of its value and the minimum from the next row.
 * - Finally, the top row will hold the minimum falling path sums for all starting points.
 * - Return the smallest one.
 *
 * Time Complexity: O(n^2) → every element in the matrix is visited once.
 * Space Complexity: O(1) → no extra space used; we modify the input matrix in place.
 */

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int n = matrix.length;

        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < n; j++) { // till i reach last column
                if(j == 0) {
                   matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]); 
                }
                else if(j == n - 1) {
                    matrix[i][j] = matrix[i][j]  + Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                } else {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], Math.min(matrix[i + 1][j - 1], matrix[i + 1][j + 1]));
                }
            }
        }
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++) {
                min = Math.min(min, matrix[0][j]);
            }
            return min;
    }
}