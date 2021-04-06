// Time Complexity :O(mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // Choose the Min of previous row values except the current column
                if (j == 0) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                } else if (j == matrix[0].length - 1) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                } else {
                    matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i - 1][j + 1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        // Iterate through all columns to find the minimum
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(matrix[matrix.length - 1][i], min);
        }
        return min;
    }
}