
//Time Complexity : O(m * n)
//Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes



class minFallingPathSum{
    public static int minFallingPathSum(int[][] matrix) {
      int rows = matrix.length;
      int cols = matrix[0].length;
      // DP matrix has 2 extra columns
      int[][] dp = new int[rows][cols + 2];
      // Fill the first row of DP matrix
      for (int i = 1; i <= cols; i++) {
        dp[0][i] = matrix[0][i - 1];
      }
      // Fill Integer.MAX_VALUE into first and last column of DP matrix
      for (int i = 0; i < rows; i++) {
        dp[i][0] = Integer.MAX_VALUE;
        dp[i][cols + 1] = Integer.MAX_VALUE;
      }
      // Building the DP matrix
      for (int i = 1; i < rows; i++) {
        for (int j = 1; j <= cols; j++) {
          // Find the minimum neighbor from previous row in DP matrix
          int minNeighbor = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
          minNeighbor = Math.min(minNeighbor, dp[i - 1][j + 1]);
          dp[i][j] = matrix[i][j - 1] + minNeighbor;
        }
      }
      // The minimum path sum is minimum of the last row in DP matrix
      int min = Integer.MAX_VALUE;
      for (int i = 1; i <= cols; i++) {
        min = Math.min(min, dp[rows - 1][i]);
      }
      return min;
    }
}
