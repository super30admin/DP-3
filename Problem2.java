// Time Complexity : O(m*n) where m and n are dimensions of the matrix
// Space Complexity : O(m*n) but can be optimized with 1d array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* 
 * Created a decision tree. Min cost of any path is cost till current + min of the costs
 * possible paths from current. As there were two inputs rows and columns, we use a dp matrix.
 * First(or last) row can be copied as if there's only one row, min cost associated with the path
 * is the cost to go through that path itself. From one row, we derive the next and so on.
 * Finally the path with the min cost is chosen.
*/

class Problem2 {
    public int minFallingPathSum(int[][] matrix) {
        // need a 2d matrix as there are 2 inputs on the tree - row and col;
        int[][] dp = new int[matrix.length][matrix[0].length];

        // if there's only one row in the matrix; copy min cost
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int min = Integer.MAX_VALUE;
                // iterating the valid paths from the prev row and picking out the minimum
                for (int k = j - 1; k <= j + 1; k++) {
                    // column out of bounds
                    if (k < 0 || k >= dp[0].length) {
                        continue;
                    }
                    // previous row
                    min = Math.min(dp[i - 1][k], min);
                }
                dp[i][j] = matrix[i][j] + min;
            }
        }

        int res = dp[dp.length - 1][dp[0].length - 1];

        for (int x = 0; x < dp[0].length; x++) {
            res = Math.min(res, dp[dp.length - 1][x]);
        }

        return res;
    }
}