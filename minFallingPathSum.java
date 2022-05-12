// Time Complexity :O(n^2) where n is row and col
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : was going in wrong direction fixed later

//we will be going top to bottom, first populate dp array first row, then will traverse each 
//index starting from second row and take minimum of neighbours from dp's previous row . At last we will
// get minimum amongst last row of dp array
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int result = Integer.MAX_VALUE;

        int n = matrix.length;
        int[][] dp = new int[n][n];
        // populating first row
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
            System.out.println(dp[i]);
            System.out.println("+++++++");
        }
        // adding neighbours

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("before dp[j] is" + dp[j]);
                System.out.println("index is" + i + "and" + j);
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j + 1], dp[i - 1][j]);
                } else if (j == n - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                } else {

                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j + 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
                }
                System.out.println("dp[j] is" + dp[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            result = Math.min(result, dp[n - 1][i]);
        }
        return result;
    }
}

// ----------------USING 1D ARRAY---------------
// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :was confused regarding using last
// index as it will be updated,
// then came to know we only need one previous index and we can store it in a
// variable

// everything is same as above except we are using one dimentional dp array , as
// mentioned above for previous index we'll store in variable
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int result = Integer.MAX_VALUE;

        int n = matrix.length;
        int[] dp = new int[n];
        // populating first row
        for (int i = 0; i < n; i++) {
            dp[i] = matrix[0][i];

        }
        // adding neighbours
        int prev = 0;
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (j == 0) {
                    int curr = dp[j];
                    dp[j] = matrix[i][j] + Math.min(dp[j + 1], dp[j]);
                    prev = curr;
                } else if (j == n - 1) {
                    int curr = dp[j];
                    dp[j] = matrix[i][j] + Math.min(prev, dp[j]);
                    prev = curr;
                } else {
                    int curr = dp[j];
                    dp[j] = matrix[i][j] + Math.min(dp[j + 1], Math.min(prev, dp[j]));
                    prev = curr;
                }
            }
        }
        // at the end of row, we'll update our dp matrix
        for (int i = 0; i < n; i++) {
            result = Math.min(result, dp[i]);
        }
        return result;
    }
}