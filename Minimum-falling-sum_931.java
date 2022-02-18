// Time Complexity : O(m*n)  : size of matrix
// Space Complexity :O(m*n) : can be reduced O(1) if only previous dp row is saved
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// dp[i][j] = Math.min(dp[i-1[[j] + matrix[i][j] , dp[i-1[[j-1] + matrix[i][j], dp[i-1[[j+1] + matrix[i][j])


class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] i : dp) {
           Arrays.fill(i, Integer.MAX_VALUE);
        }

        dp[0] = matrix[0];
        for (int i=1; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + matrix[i][j]);
                if (j-1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + matrix[i][j]);
                }

                if(j+1 < matrix[0].length) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1] + matrix[i][j]);
                }

            }
        }

        int res = Integer.MAX_VALUE;
        for(int i : dp[dp.length -1 ]){
            res = Math.min(res, i);
        }
        return res;
    }
}
