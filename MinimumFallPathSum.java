public class MinimumFallPathSum {
  public int MinimumFallingPathSum(int[][] matrix) {
    int[][] dp = new int[matrix[0].length][matrix.length];
    for (int i = 0; i < matrix[0].length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (i == 0) {
          dp[i][j] = matrix[i][j];
        } else if (j == 0) {
          dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
        } else if (j == matrix.length - 1) {
          dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
        } else {
          dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
        }
      }
    }
    int minSum = Integer.MAX_VALUE;
    for (int j = 0; j < dp.length; j++) {
      minSum = Math.min(minSum, dp[dp[0].length - 1][j]);
    }
    return minSum;
  }

  public static void main(String[] args) {
    MinimumFallPathSum minFall = new MinimumFallPathSum();
    int[][] matrix1 = { { -19, 57 }, { -40, -5 } };
    System.out.println(minFall.MinimumFallingPathSum(matrix1));
    int[][] matrix2 = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
    System.out.println(minFall.MinimumFallingPathSum(matrix2));
  }
}