/*
 * LeetCode Problem: 931. Minimum Falling Path Sum
 * Approach: Dynamic Programming
 * * 1. We can solve this problem using a dynamic programming approach.
 * * 2. We will iterate through the matrix from the second last row to the top row.
 * * 3. For each cell, we will calculate the minimum falling path sum by considering the three possible cells in the row below it (directly below, below left, and below right).
 * * 4. We will update the current cell with the minimum falling path sum from the row below.   
 * * 5. Finally, we will return the minimum value from the first row, which will give us the minimum falling path sum.
 *  
 * Time Complexity: O(n^2) where n is the number of rows (or columns) in the matrix.
 * Space Complexity: O(1) since we are modifying the input matrix in place. 
 * 
 */
public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                } else if (j == n - 1) {
                    matrix[i][j] += matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                } else {
                    matrix[i][j] = matrix[i][j]
                            + Math.min(matrix[i + 1][j], Math.min(matrix[i + 1][j - 1], matrix[i + 1][j + 1]));
                }
            }
        }
        return Arrays.stream(matrix[0]).min().getAsInt();
    }
}
