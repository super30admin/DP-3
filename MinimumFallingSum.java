// Time Complexity : O(n*N) where n is the number of rows (or columns) in the input matrix. We iterate through each cell in the matrix to fill the dp array.
// Space Complexity : O(n*N) where n is the number of rows (or columns) in the input matrix. We use an additional 2D array dp to store the minimum falling path sum up to each cell.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// We can use dynamic programming to solve this problem. 
// We create a 2D dp array where dp[i][j] represents the minimum falling path sum to reach cell (i, j).
//  We initialize the first row of the dp array with the values from the first row of the input matrix.
//  Then, for each subsequent row, we calculate the minimum falling path sum for each cell by considering the three possible cells from which we can come: directly above (i-1, j), diagonally left (i-1, j-1), and diagonally right (i-1, j+1).
//  Finally, we find the minimum value in the last row of the dp array, which represents the minimum falling path sum from top to bottom.


class Solution {

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        int min = Integer.MAX_VALUE;

        int[][] dp = new int[n][n];

        // First row initialization
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Fill DP table
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (j == 0) {

                    dp[i][j] = matrix[i][j] +
                            Math.min(dp[i - 1][j],
                                     dp[i - 1][j + 1]);

                } else if (j == n - 1) {

                    dp[i][j] = matrix[i][j] +
                            Math.min(dp[i - 1][j - 1],
                                     dp[i - 1][j]);

                } else {

                    dp[i][j] = matrix[i][j] +
                            Math.min(
                                Math.min(dp[i - 1][j - 1],
                                         dp[i - 1][j]),
                                dp[i - 1][j + 1]
                            );
                }
            }
        }

        // Find minimum in last row
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }

        return min;
    }
}