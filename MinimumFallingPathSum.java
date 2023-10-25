// Time complexity : O(n*m) , n -> rows length , m -> columns length
// Space Complexity : O(n*m) , But we can optimize this if we mutate the same array
public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        int result = minFallingPathSum(matrix);
        System.out.println(result);
    }

    private static int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int j = 0; j < m; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                } else if (j == m - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j + 1], dp[i + 1][j - 1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            min = Math.min(min, dp[0][i]);
        }
        return min;

    }

}
