// Approach: This can be solved using recursion, but since we see recurring subproblems, we could try dynamic programming,
// where we calcute minimum running sum while traversing through each path.
//Time Complexity : O(mxn)
//Space Complexity : O(mxn)

class Solution {
    public int minFallingPathSum(int[][] matrix) {

        //Validate inputs
        if (matrix == null || matrix.length == 0) return 0;

        //Initialize variables and dp matrix
        int minSum = Integer.MAX_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        //Initialize the first row of the dp matrix with the input matrix
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Identify left, right and middle values for each element while traversing and find the minumum possible to get a minSum
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int middle = dp[i - 1][j];
                int left = (j - 1 >= 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int right = (j + 1 < n) ? dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(left, Math.min(middle, right));;
            }
        }

        //Iterate through the last row and find the minimum value
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[m - 1][j]);
        }

        return minSum;
    }