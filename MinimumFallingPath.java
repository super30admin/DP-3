//Time Complexity: O(M x N)
//        Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int[][] dp = new int[matrix.length + 1][matrix.length + 1];

        for (int i = matrix.length - 1; i >= 0; i--) {

            for (int j = 0; j < matrix.length; j++) {

                if (j == 0) {
                    System.out.print(dp[i][j]);
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                    System.out.print(dp[i][j]);
                }
                (j == (matrix.length - 1)){
                    System.out.print(dp[i][j]);
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j-1], dp[i+1][j]);
                    System.out.print(dp[i][j]);
                }
                {
                    System.out.print(dp[i][j]);
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i+1][j], dp[i+1][j-1]), dp[i+1][j+1]);
                    System.out.print(dp[i][j]);
                }
            }
        }

        int minPath = Integer.MAX_VALUE;

        for (int col = 0; col < matrix.length; col++) {
            minPath = Math.min(minPath, dp[0][col]);
        }

        return minPath;
    }
}