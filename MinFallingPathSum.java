//TC: O(N^2) SC: O(N)
class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n+1];
        for(int row = n-1; row >= 0; row--) {
            int[] currRow = new int[n+1];
            for(int col = 0; col < n; col++) {
                if(col == 0) currRow[col] = Math.min(dp[col],dp[col+1]) + matrix[row][col];
                else if(col == n-1) currRow[col] = Math.min(dp[col],dp[col-1]) + matrix[row][col];
                else currRow[col] = Math.min(dp[col], Math.min(dp[col-1],dp[col+1])) + matrix[row][col];
            }
            dp = currRow;
        }
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) minSum = Math.min(minSum, dp[i]);
        return minSum;
    }
}