//Time Complexity: O(N*N) Number of rows and columns
//Space Complexity: O(N*N) Number of rows and columns
class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int[][] dp = new int[matrix.length + 1][matrix.length + 1];


        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == 0) dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                else if (j == matrix.length - 1) dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j-1], dp[i+1][j]);
                else dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i+1][j], dp[i+1][j-1]), dp[i+1][j+1]);
            }
        }
        int minPath = Integer.MAX_VALUE;
        for (int col = 0; col < matrix.length; col++) minPath = Math.min(minPath, dp[0][col]);
        return minPath;
    }
}