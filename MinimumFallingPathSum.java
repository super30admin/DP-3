// Time Complexity : O(n2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int minRes = Integer.MAX_VALUE;

        if (n == 1)
            return matrix[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    matrix[i][j] += Math.min(matrix[i - 1][0], matrix[i - 1][1]);
                else if (j == n - 1)
                    matrix[i][j] += Math.min(matrix[i - 1][n - 1], matrix[i - 1][n - 2]);

                else
                    matrix[i][j] += Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]));

                if (i == n - 1)
                    minRes = Math.min(minRes, matrix[i][j]);
            }
        }

        return minRes;
    }
}
