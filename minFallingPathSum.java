// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //Base case
        if (matrix == null || matrix.length == 0) return 0;

        int n = matrix.length;
        int min = Integer.MAX_VALUE;

        // find min in matrix
        for (int j = 0; j < n; j++) {
            //call helper to find min and compare to curr min
            min = Math.min(min, helper(matrix, 0, j));
        }

        return min;
    }

    private int helper(int[][] matrix, int i, int j) {
        int n = matrix.length;

        if (j < 0 || j >= n) {
            return Integer.MAX_VALUE;
        }

        // reached bottom, return 0
        if (i == n) {
            return 0;
        }

        // Recursively explore 3 possible moves (straight down, diagonal right, diagonal left
        int down = helper(matrix, i + 1, j);
        int downLeft = helper(matrix, i + 1, j - 1);
        int downRight = helper(matrix, i + 1, j + 1);

        // Curr value + best choice between 3 possible moves
        return matrix[i][j] + Math.min(down, Math.min(downLeft, downRight));
    }
}
