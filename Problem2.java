// adding one extra row at top and two extra columns on left and rifht 
//for edge cases and those extra rows are filled with max value and pass through
//first row and copy same value for dp array and second passing where I actually make calculations based on previous row

// o(mxn) space complexity
// O(mXn) time complexity
class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m + 1][n + 2];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][n + 1] = Integer.MAX_VALUE;
        }


        for (int j = 1; j <= n; j++) {
            dp[1][j] = matrix[0][j - 1];
        }

        for (int i = 2; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                int minPrevious = Math.min(
                    dp[i - 1][j],
                    Math.min(
                        dp[i - 1][j - 1],
                        dp[i - 1][j + 1]
                    )
                );

                dp[i][j] = matrix[i - 1][j - 1] + minPrevious;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int j = 1; j <= n; j++) {
            min = Math.min(min, dp[m][j]);
        }

        return min;
    }
}
