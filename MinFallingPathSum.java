class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // Check if the matrix is empty or null; return -1 in such cases
        if (matrix.length == 0 || matrix == null)
            return -1;

        int n = matrix.length;

        // Iterate through the rows starting from the second-to-last row and moving upward
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                else if (j == n - 1)
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                else
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j - 1], Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]));
            }
        }

        // Find the minimum value in the first row, which represents the minimum falling path sum
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++)
            min = Math.min(min, matrix[0][j]);

        return min;
    }
}

// Time Complexity: O(N), where N is the number of rows (assuming the matrix is square)
// Space Complexity: O(N^2), as the matrix itself has N^2 elements
