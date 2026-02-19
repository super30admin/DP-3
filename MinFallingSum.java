// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
/*
This problem has repetitive subproblems when solved with recursion. So, we optimize it with DP where we
take a 1D DP array. Our main intention is to either make cumulative min sum from element in next row directly
or diagonally left/right depending upon possibility. So, we are not interested in remembering previous row's
data. So, we intialize a single row to store the computed data and replace it as we iterate. We need to check
edge cases while computing min sum and eventually compare the min running sum using minSum variable.
 */

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        int[] dp = new int[len + 1];

        for(int i = len - 1 ; i >= 0 ; i--) {
            int[] currRow = new int[len + 1];
            for(int j = 0 ; j < len ; j++) {
                if(j == 0) {
                    currRow[j] = Math.min(dp[j] , dp[j + 1]) + matrix[i][j];
                }
                else if(j == len - 1)
                    currRow[j] = Math.min(dp[j], dp[j - 1]) + matrix[i][j];
                else
                    currRow[j] = Math.min(dp[j] , Math.min(dp[j + 1], dp[j - 1])) + matrix[i][j];
            }
            dp = currRow;
        }

        int minSum = Integer.MAX_VALUE;
        for(int i = 0 ; i < len ; i++)
            minSum = Math.min(minSum, dp[i]);
        return minSum;
    }
}