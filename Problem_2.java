// Time Complexity : O(n^2) + O(n) = O(n ^ 2), where n array of integers
// Space Complexity : O(n ^ 2), size of dp array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We then use dp here. We create a 2d dp array and and store last row of matrix in last row of dp array. Then we iterate from bottom
   and start filling in values in dp array taking into account each case where we take the three possible paths and take minimum of it.
   After the dp array is filled, we check the minimum value in first row. That is our minFallingPath Sum.
*/

class Solution {
   public int minFallingPathSum(int[][] matrix) {
       if(matrix == null || matrix.length == 0)
           return -1;

       int n = matrix.length;
       int[][] dp = new int[n][n];

       for(int j = 0; j < n; ++j) 
           dp[n - 1][j] = matrix[n - 1][j];

       for(int i = n - 2; i >= 0; --i) {
           for(int j = 0; j < n; ++j) {
               if(j == 0)
                   dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
               else {
                   if(j == n - 1)
                       dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
                   else    
                       dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j - 1], dp[i + 1][j + 1]));
               }
           }
       }

       int min = dp[0][0];
       for(int j = 1; j < n; ++j) {
           min = Math.min(min, dp[0][j]);
       }
       return min;
   }
}