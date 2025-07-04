// Time Complexity: O(m * n) 
// Space Complexity: O(m * n)

// Using a memoization table to store the minimum falling path from 1 row above

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int dp[][] = new int[matrix.length][matrix[0].length];

        for (int j=0; j<matrix[0].length; j++) {
            dp[0][j] = matrix[0][j]; // setting the value as first row's values. different starting paths
        }

        for (int i=1; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (j == 0) {
                    // left edge
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                } else if (j == matrix[0].length-1) {
                    // right edge
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int n : dp[matrix.length-1]) {
            if (n < min) {
                min = n;
            }
        }
        return min;
    }
}
