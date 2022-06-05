// Time Complexity :O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
class minFallingpathSum {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length+1][matrix.length+1];
        for(int j =0; j < matrix[0].length; j++){
            dp[matrix.length-1][j] = matrix[matrix.length-1][j];
        }
        for(int i = matrix.length-2; i>=0 ; i--){
            for(int j = 0; j< matrix[0].length; j++){
                if(j == 0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
                else if ( j == matrix[i].length - 1){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j-1]);
                }
                else{
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], Math.min(dp[i+1][j+1], dp[i+1][j-1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length; i++){
            min = Math.min(min, dp[0][i]);
        }
        return min;
    }
}