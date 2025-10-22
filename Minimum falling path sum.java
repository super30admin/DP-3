class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int min = Integer.MAX_VALUE;

        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = matrix[0][i];
        }

        for(int i = 1; i < n; i++) {
            int diagUp = dp[0];
            for(int j = 0; j < n; j++) {
                int temp = dp[j];
                if(j == 0 ) {
                    dp[j] = matrix[i][j] + Math.min(dp[j], dp[j+1]);
                } else if(j == n - 1){
                    dp[j] = matrix[i][j] + Math.min(diagUp, dp[j]);
                }
                else {
                    dp[j] = matrix[i][j] + Math.min((Math.min(diagUp, dp[j])), dp[j + 1]);
                }
                diagUp = temp;
            }
        }
        for(int i = 0; i < n; i++){
            min = Math.min(min, dp[i]);
        }

        return min;
    }
}
