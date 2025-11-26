// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
You build a DP table where each cell stores the minimum path sum to reach that position from the row above.
For every cell, you add its value to the minimum of the valid three options from the previous row (straight, left-diag, right-diag).
The answer is simply the minimum value in the last row of the DP table.
*/

public class Problem2 {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int j = 0;j<n;j++) {
            dp[0][j] = matrix[0][j];
        }

        for(int i = 1;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if(j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                } else if(j == n-1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for(int j = 0;j<n;j++) {
            if(dp[m-1][j] < min) {
                min = dp[m-1][j];
            }
        }

        return min;
    }
}
