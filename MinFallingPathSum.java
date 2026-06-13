class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // TC = O(n^2)
        // SC = O(n^2)
        int n = matrix.length;
        int m = matrix[0].length;
        // create a 2d array to store the minimum path from that index, added one more row/column for ease of calculation
        int dp[][] = new int[n + 1][m + 1];

        if (n == 1) {
            return matrix[0][0];
        }

        // iterating from the bottom of the array nnd keep finding minimum as we go up
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
            // if it is the first column, we only need to check j and j+1 to not go out of bounds
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + matrix[i][j];
                } else if (j == m - 1) {
                    // if it is the last column, we only need to check j and j-1 to not go out of bounds
                    dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j-1]) + matrix[i][j];
                }  else {
                    // otherwise check all 3 paths
                    dp[i][j] = Math.min(dp[i+1][j], Math.min(dp[i+1][j-1], dp[i+1][j+1])) + matrix[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        // traverse the first row of the array to find the minimum calculated path
        for (int j = 0; j < m; j++) {
            if (min > dp[0][j]) {
                min = dp[0][j];
            }
        }
        return min;
    }
}