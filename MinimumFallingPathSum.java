//Time Complexity: O(MN)
//Space Complexity: O(MN)
//Runtime: 3 ms, faster than 81.92% of Java online submissions for Minimum Falling Path Sum.
//Memory Usage: 39.5 MB, less than 64.78% of Java online submissions for Minimum Falling Path Sum.
//iterative solution
class Solution {
  public int minFallingPathSum(int[][] matrix) {

    int ans = Integer.MAX_VALUE;

    int col = matrix[0].length;
    int row = matrix.length;
    int[][] dp = new int[row][col];

    for (int i = 0; i < col; i++) {
      dp[0][i] = matrix[0][i];
    }

    for (int i = 1; i < row; i++) {
      for (int j = 0; j < col; j++) {

        if (j != 0 && j != matrix[0].length - 1) {
          dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
        } else if (j == 0) {
          dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
        } else if (j == matrix[0].length - 1) {
          dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);

        }

      }
    }

    for (int i = 0; i < col; i++) {
      ans = Math.min(dp[row - 1][i], ans);
    }

    return ans;
  }

  
  
  
  // Recusrsive solution
  private int helper(int[][] matrix, int col, int row, int amount) {

    if (row == matrix.length)
      return amount;

    int case1 = Integer.MAX_VALUE;
    if (col != 0 && col != matrix[0].length - 1) {
      case1 = Math.min(helper(matrix, col, row + 1, amount + matrix[row][col]),
        Math.min(helper(matrix, col - 1, row + 1, amount + matrix[row][col]),
          helper(matrix, col + 1, row + 1, amount + matrix[row][col])));
    } else if (col == 0) {
      case1 = Math.min(helper(matrix, col + 1, row + 1, amount + matrix[row][col]),
        helper(matrix, col, row + 1, amount + matrix[row][col]));
    } else if (col == matrix[0].length - 1) {
      case1 = Math.min(helper(matrix, col - 1, row + 1, amount + matrix[row][col]),
        helper(matrix, col, row + 1, amount + matrix[row][col]));

    }
    return case1;

  }
}
