/*

// Time Complexity : O(n *m) where n is number of row and m is number of column.
// Space Complexity : O(n *m) where n s number of row and m is number of column.
// Did this code successfully run on Leetcode : Yes

*/

public class minimumpath {

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {

            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {

            dp[i][0] += matrix[i][0] + Math.min(dp[i - 1][0], dp[i - 1][1]);

            dp[i][m - 1] += matrix[i][m - 1] + Math.min(dp[i - 1][m - 1], dp[i - 1][m - 2]);

            for (int j = 1; j < m - 1; j++) {

                dp[i][j] += matrix[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {

            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}