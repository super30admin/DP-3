// Time Complexity :O(n^2)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started


// Your code here along with comments explaining your approach

public class MinimumFailingPathSum {
    class Solution {
        public int minFallingPathSum(int[][] A) {
            int m = A.length, n = A[0].length;
            int dp[][] = new int[m][n];

            //copy base case which is A[0][i] in to dp
            for(int i = 0; i<n; i++){
                dp[0][i] = A[0][i];
            }

            for(int i = 1; i<m; i++){
                for(int j = 0; j<n; j++) {
                    //computer for elements on far left
                    if (j == 0) {
                        dp[i][j] = A[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                        //compute for elements on far right
                    } else if (j == n - 1) {
                        dp[i][j] = A[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                        //compute for elements not on far left or right
                    } else {
                        dp[i][j] = A[i][j] + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]);
                    }
                }
            }

            int result = Integer.MAX_VALUE;

            //find minimum value in last row and return it
            for(int x : dp[m-1]){
                result = Math.min(result, x);
            }

            return result;
        }
    }
}
