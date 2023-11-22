// Time Complexity : O(n^2)
// Space Complexity : O(2n) -> O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Using DP Bottom Up Approach, for every forthcoming row, we will have 3 options to choose from (2 diagonals, 1 below).At each
 * stage, Calculate the sum of current cost + cost of option for next row. Do it for all 3 options and store the
 * min. Do it for all entire matrix. Final ans will be the minimum of all from the last row
 */

class Solution {

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++)
            dp[i] = matrix[n - 1][i];

        for (int i = n - 2; i >= 0; i--) {
            int[] current = new int[n];
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    current[j] = matrix[i][j] + Math.min(dp[j], dp[j + 1]);
                else if (j == n - 1)
                    current[j] = matrix[i][j] + Math.min(dp[j], dp[j - 1]);
                else
                    current[j] = matrix[i][j] + Math.min(dp[j], Math.min(dp[j - 1], dp[j + 1]));
            }
            dp = current;
        }

        int min = dp[0];
        for (int i = 1; i < n; i++)
            min = Math.min(min, dp[i]);

        return min;
    }
}


/*
class Solution {
    public int minFallingPathSum(int[][] matrix) {
         if(matrix.length == 1) return matrix[0][0];

         int min = Integer.MAX_VALUE;

         for(int i=0; i<matrix.length; i++)
             min = Math.min(min, helper(matrix, 0, i, 0));

         return min;
    }

     private int helper(int[][] matrix, int sum, int i, int row) {

         //base
         if(i < 0 || i == matrix.length) return Integer.MAX_VALUE;
         if(row == matrix.length) return sum;

         //logic
         if(i == 0)
             return Math.min(helper(matrix, sum+matrix[row][i], i, row+1), helper(matrix, sum+matrix[row][i+1], i+1, row+1));
         else if(i == matrix.length-1)
             return Math.min(helper(matrix, sum+matrix[row][i], i, row+1), helper(matrix, sum+matrix[row][i-1], i-1, row+1));
         else
             return Math.min(helper(matrix, sum+matrix[row][i], i, row+1), Math.min(helper(matrix, sum+matrix[row][i-1], i-1, row+1),
                                                                                    helper(matrix, sum+matrix[row][i+1], i+1, row+1)));

     }
}*/
