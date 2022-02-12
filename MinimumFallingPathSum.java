// Time Complexity: O(n) where n is the max value in nums
// Space Complexity: O(n) where n is the max value in nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Create a new 2D array called dp. Copy the first row from matrix.
// We start iterating from 2nd row and find the min from previous row.
// We add this min to the val of matrix[i][j] and store it at dp[i][j].
// At the end, we just have to find the minimum from the last row of dp.

// LC- 931 Minimum Falling Path Sum

public class MinimumFallingPathSum {
  public int minFallingPathSum(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int[][] dp = new int[matrix.length][matrix.length];

    for (int i = 0; i < matrix.length; i++) {
      dp[0][i] = matrix[0][i];
    }

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (j == 0) {
          dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
        } else if (j == matrix.length - 1) {
          dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
        } else {
          dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
        }
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < matrix.length; i++) {
      if (dp[matrix.length - 1][i] < min) {
        min = dp[matrix.length - 1][i];
      }
    }

    return min;
  }
}
