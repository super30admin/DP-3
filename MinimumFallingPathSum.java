// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: We keep the first row constant while constructing the dp array and then iterate on remaining elements in the matrix
// 2: For each element, we calculate the minimum of left, top, and right and then fill in the dp array with that value
// 3: At the end, we find the minimum from the last row and return the minimum value found
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; // square

        int[][] dp = new int[n][n];

        // keeping the first row constant
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        int maxVal = Integer.MAX_VALUE / 2;
        int minimumSum = maxVal;
        int left = 0, right = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                if (j > 0)
                    left = matrix[i][j] + dp[i - 1][j - 1];
                else
                    left = maxVal;

                if (j < n - 1)
                    right = matrix[i][j] + dp[i - 1][j + 1];
                else
                    right = maxVal;

                int min = Math.min(up, Math.min(left, right));
                dp[i][j] = min;
            }
        }

        for (int i = 0; i < n; i++) {
            minimumSum = Math.min(minimumSum, dp[n - 1][i]);
        }

        return minimumSum;

    }
}