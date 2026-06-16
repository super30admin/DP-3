// Time complexity : O(n^2)
// Space Complexity: O(n^2)
// We start by filling the last row of DP array with the last row of matrix where dp[i][j]
// is the minimum sum path until then.
class MinFallingSum {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n= matrix[0].length;
        int[][] dp = new int[m][n];

        // fill the dp array with the last row of the matrix
        for(int i = 0; i < n; i++ ) {
            dp[m-1][i] = matrix[m-1][i];
        }

        // calculate the min sum
        for(int i = m-2; i>=0; i--){
            for(int j=0; j<n; j++) {
                if(j==0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                } else if (j == n-1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j-1]);
                } else{
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j],Math.min(dp[i+1][j-1], dp[i+1][j+1]));
                }
            }
        }

        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++ ) {
            minValue = Math.min(minValue, dp[0][i]);
        }

        return minValue;
    }
}