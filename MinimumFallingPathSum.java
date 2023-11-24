//  Time complexity: O(mn)
//  Space Compoexity: O(mn)
class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int dp[][] = new int[m][n];
        for(int j=0; j< n; j++)
            dp[m-1][j] = matrix[m-1][j];


        for(int i= m -2; i >=0; i--){

            dp[i][0] = matrix[i][0] +  Math.min(dp[i+1][0], dp[i+1][1]);

            for(int j = 1; j<n-1; j++){
               
                dp[i][j] =  matrix[i][j] +  Math.min(dp[i+1][j-1], Math.min(dp[i+1][j], dp[i+1][j+1]));
            }
            dp[i][n-1] = matrix[i][n-1] +  Math.min(dp[i+1][n-1], dp[i+1][n-2]);

        }

        int ans = dp[0][0];
        for(int i=1; i< n; i++){
            ans = Math.min(ans, dp[0][i]);
        }

        return ans;

    }
}