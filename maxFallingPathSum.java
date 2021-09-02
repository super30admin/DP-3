// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // store the dimentsions of matrix in variables m and n
        int m = matrix.length;
        int n = matrix[0].length;
        // intialize dp matrix of m x n
        int[][] dp = new int[m][n];
        // intitialize min
        int min = Integer.MAX_VALUE;
        // fill the first row of dp matrix as it is in the given matrix
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }
        // for the rest of the rows
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                // in case of 0th col, only consider the element exactly above
                // and element above right
                if(j == 0){
                    // take sum of the element with the min value between the
                    // previous elements satifying the above condition
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i-1][j + 1]);
                }
                // in case of last col, only consider the element exactly above
                // and element above left
                else if(j == n - 1){
                    // take sum of the element with the min value between the
                    // previous elements satifying the above condition
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i - 1][j - 1]);
                }
                // else consider the elements exactly above, left above and right above
                else {
                    // take sum of the element with the min value between the
                    // previous elements satifying the above condition
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]),
                            dp[i - 1][j + 1]);
                }
            }
        }
        // find the min value in the last row and return it
        for(int i = 0; i < n; i++){
            min = Math.min(min, dp[m - 1][i]);
        }
        return min;
    }
}