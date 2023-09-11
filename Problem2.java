// Time Complexity : O(n + n^2) we loop through last row of matrix and then all rows X col to identify min
// Space Complexity : O(n*n) dp matrix to store min at each index.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    public int minFallingPathSum(int[][] matrix) {
        //base case
        int row = matrix.length;
        int col = matrix[0].length;

        int dp[][] = new int[row][col];
        for(int c = 0; c < col; c++){
            dp[row - 1][c] = matrix[row-1][c];
        }

        for(int i = row - 2; i >= 0; i--){
            for(int j = 0; j < col; j++){
                if(j == 0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i+1][j+1]);
                }else if(j == col-1){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j-1], dp[i + 1][j]);
                }else{
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j-1], Math.min(dp[i + 1][j], dp[i+1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < col; i++){
            min = Math.min(min, dp[0][i]);
        }

        return min;
    }
}
