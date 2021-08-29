// TIME: O(n^2)
// SPACE: O(n^2)
// SUCCESS on LeetCode


public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i];
        }
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j - 1 < 0) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + matrix[i][j];
                } else if (j + 1 > matrix[0].length - 1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + matrix[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1])) + matrix[i][j];
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(min, dp[matrix.length - 1][i]);
        }
        
        return min;
    }
}
