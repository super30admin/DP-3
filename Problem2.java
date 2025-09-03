// Time Complexity : O(n*n)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Uses Tablulation, bottom up approach to find the minimum falling sum path
We start keeping the bottom row same and compute the above rows using the formula that either we pick the element below it
or right to it or left to it and sum up the element with its minimum
The minimum sum or result will the minimum of elements in first row
*/
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];

        //Base case
        //last row to be kept same
        for(int j = 0; j<n; j++) {
            dp[n-1][j] = matrix[n-1][j];
        }

        for(int i = n-2;i>=0;i--) {
            for(int j=0;j<n;j++) {
                int down = dp[i+1][j];
                int right = (j < n-1) ? dp[i+1][j+1] : Integer.MAX_VALUE;
                int left = (j > 0) ? dp[i+1][j-1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(right, left));
            }
        }
        int minSum = Integer.MAX_VALUE;
        for(int j =0; j<n ;j++) {
            minSum = Math.min(minSum, dp[0][j]);
        }
        return minSum;
        
    }
}
