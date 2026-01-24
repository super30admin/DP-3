// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    int[] dirs;
    int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        this.dirs = new int[] { -1, 0, 1 }; // to try all the possible direction
        int min = Integer.MAX_VALUE;
        int len = matrix.length;
        this.memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                memo[i][j] = Integer.MAX_VALUE;// to keep track of which cells have then changed later
            }
        }
        for (int i = 0; i < len; i++) {// loop over all columns
            min = Math.min(min, helper(matrix, i, 0));// min for all the columns
        }
        return min;
    }

    private int helper(int[][] matrix, int n, int m) {
        if (m == matrix.length) {
            return 0;
        }
        if (memo[m][n] != Integer.MAX_VALUE) {
            return memo[m][n];// if the m n has be solved before we return the value instead of recomputing it
        }

        // logic
        int sum = matrix[m][n];
        int minFromChildren = Integer.MAX_VALUE;
        for (int dir : dirs) {
            int newDir = n + dir;
            if (newDir >= 0 && newDir < matrix[0].length) {// bound checks
                minFromChildren = Math.min(minFromChildren, helper(matrix, newDir, m + 1));

            }
        }
        memo[m][n] = minFromChildren + sum;
        return memo[m][n];
    }
}