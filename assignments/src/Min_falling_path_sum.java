public class Min_falling_path_sum {

    // Time: O(n^2), Space: O(n)
    public int minFallingPathSum(int[][] matrix) {

        int dp[] = new int[matrix[0].length+1];

        for (int i = matrix.length-1; i>=0; i--) {
            int currRow[] = new int[matrix[0].length+1];
            for (int j = 0; j<matrix.length; j++) {
                if (j == 0) {
                    currRow[j] = Math.min(dp[j], dp[j+1]) + matrix[i][j];
                }
                else if (j == matrix.length-1) {
                    currRow[j] = Math.min(dp[j], dp[j-1]) + matrix[i][j];
                }
                else {
                    currRow[j] = Math.min(dp[j], Math.min(dp[j+1], dp[j-1])) + matrix[i][j];
                }
            }
            dp = currRow;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i<matrix.length; i++) {
            if (dp[i] < min) min = dp[i];
        }
        return min;
    }
}