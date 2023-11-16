// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class PathSum {
    public int minFallingPathSum(int[][] matrix) {
        int dp[] = new int[matrix.length + 1];
        for (int row = matrix.length - 1; row >= 0; row--) {
            int currentRow[] = new int[matrix.length + 1];
            for (int col = 0; col < matrix.length; col++) {
                if (col == 0) {
                    currentRow[col] =
                        Math.min(dp[col], dp[col + 1]) + matrix[row][col];
                } else if (col == matrix.length - 1) {
                    currentRow[col] =
                        Math.min(dp[col], dp[col - 1]) + matrix[row][col];
                } else {
                    currentRow[col] = Math.min(dp[col],
                        Math.min(dp[col + 1], dp[col - 1])) + matrix[row][col];
                }
            }
            dp = currentRow;
        }
        int minFallingSum = Integer.MAX_VALUE;
        for (int startCol = 0; startCol < matrix.length; startCol++) {
            minFallingSum = Math.min(minFallingSum, dp[startCol]);
        }
        return minFallingSum;
    }
}