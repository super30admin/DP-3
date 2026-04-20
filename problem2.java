    /**
    Time Complexity : O(N^2)
    Explanation:
    We fill an N x N DP table, processing each cell once.

    Space Complexity : O(N^2)
    Explanation:
    DP table of size N x N is used.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially struggled with boundary conditions (first and last column).
    Fixed it by handling:
        - j == 0 → can only come from down or down-right
        - j == n-1 → can only come from down or down-left
    Also needed to correctly take minimum of all three possible directions.
    */


    class Solution {


        public int minFallingPathSum(int[][] matrix) {
    
            int n = matrix.length;
    
            int[][] dp = new int[n][n];
            int min = Integer.MAX_VALUE;
    
            // Base case: last row
            for (int i = 0; i < n; i++) {
                dp[n - 1][i] = matrix[n - 1][i];
            }
    
            // Fill DP from bottom to top
            for (int i = n - 2; i >= 0; i--) {
    
                for (int j = 0; j < n; j++) {
    
                    if (j == 0) {
                        dp[i][j] = matrix[i][j] +
                                   Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                    }
                    else if (j == n - 1) {
                        dp[i][j] = matrix[i][j] +
                                   Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
                    }
                    else {
                        dp[i][j] = matrix[i][j] +
                                   Math.min(dp[i + 1][j],
                                   Math.min(dp[i + 1][j - 1], dp[i + 1][j + 1]));
                    }
                }
            }
    
            // Find minimum in first row
            for (int i = 0; i < n; i++) {
                min = Math.min(min, dp[0][i]);
            }
    
            return min;
        }
    }