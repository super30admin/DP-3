// Time Complexity : O(n*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

public class Problem2 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int i = n - 2; i >= 0; i--) { // start from second-last row
            for (int j = 0; j < n; j++) {
                int down = matrix[i + 1][j];
                int left = (j > 0) ? matrix[i + 1][j - 1] : Integer.MAX_VALUE;
                int right = (j < n - 1) ? matrix[i + 1][j + 1] : Integer.MAX_VALUE;

                matrix[i][j] += Math.min(down, Math.min(left, right));
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, matrix[0][j]); // top row now holds min paths
        }
        return minSum;
    }
}
