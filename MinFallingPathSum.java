//https://leetcode.com/problems/minimum-falling-path-sum/
/*
Time: O(n^2) where n=matrix.length
Space: O(n^2)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class MinFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++)
            dp[n - 1][j] = matrix[n - 1][j]; // Last row is the same as input

        for (int i = n - 2; i >= 0; i--) // bottom up
        {
            for (int j = 0; j < n; j++) { // Note: you can go either directly below or diagonally left/right

                if (j == 0)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);

                else if (j == n - 1)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j - 1]);

                else
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i + 1][j - 1], dp[i + 1][j]), dp[i + 1][j + 1]);

            }
        }

        // Find min of 1st row
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            System.out.println(dp[0][j]);
            min = Math.min(min, dp[0][j]);
        }

        return min;

    }

}
