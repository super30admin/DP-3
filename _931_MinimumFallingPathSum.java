class Solution {
    public int minFallingPathSum(int[][] matrix) {

      int[][] dp = new int[matrix.length + 1][matrix[0].length + 2];

      for(int i=0; i<dp.length; i++){
        for(int j = 0 ; j< dp[0].length; j++){

          if(i == 0 || j == 0 || j == dp[0].length-1){
            dp[i][j] = 0;
          }
          else{
            dp[i][j] = matrix[i-1][j-1] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]));
          }
        }
      }

      int res = Integer.MAX_VALUE;
      for(int j=1; j<dp[0].length-1; j++){
        res = Math.min(res, dp[matrix.length][j]);
      }
      return res;
    }
}
