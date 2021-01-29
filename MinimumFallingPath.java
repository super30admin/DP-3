// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
public class MinimumFallingPath {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length, m = matrix[0].length;

        // replace the current value with min uptill now
        for (int i = 1; i < n; i++) {
            // first val can have only a val above itslef and right val
            matrix[i][0] += Math.min(matrix[i - 1][0], matrix[i - 1][1]);
            // last val can only have a val above itself and left val
            matrix[i][m - 1] += Math.min(matrix[i - 1][m - 2], matrix[i - 1][m - 1]);

            // middle values can compare with all 3 values
            for (int j = 1; j < m - 1; j++) {

                matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i - 1][j + 1]));

            }
        }

        int min = matrix[n - 1][0];

        for (int k : matrix[n - 1])
            if (k < min)
                min = k;

        return min;
    }
}
