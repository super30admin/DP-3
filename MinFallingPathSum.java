// Time Complexity : O(n^2) + O(n) : O(n^2); n = len of matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);

                else if (j == n - 1)
                    matrix[i][j] += Math.min(matrix[i + 1][j - 1], matrix[i + 1][j]);

                else
                    matrix[i][j] += Math.min(Math.min(matrix[i + 1][j - 1], matrix[i + 1][j]),
                            Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]));
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(matrix[0][j], minSum);
        }
        return minSum;
    }
}
