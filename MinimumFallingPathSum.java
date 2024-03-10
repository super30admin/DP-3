// Time Complexity : O(N) 
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, playing around with the indices

/*Approach:
Use DP to store the current minimum at that index by adding the current value to it's bottomleft, bottom or bottomright values
We consider different cases for these and finally return the minumum from the last row of DP matrix*/
class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for (int i=0; i< m ; i++){
            dp[0][i] = matrix[0][i];
        }
        if (matrix == null || matrix.length == 0) return 0;

        for (int i = 1; i < n; i++){
            for( int j = 0; j < m; j++){
                int mini = Integer.MAX_VALUE;
                if(i-1>=0){
                    mini = Math.min(mini,dp[i-1][j]);
                }
                if(i-1>=0 && j-1>=0){
                    mini= Math.min(mini,dp[i-1][j-1]);
                }
                if(i-1>=0 && j+1<m){
                    mini = Math.min(mini,dp[i-1][j+1]);
                }

                dp[i][j] = mini + matrix[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for( int j=0;j <n ;j++){
            min = Math.min(min, dp[n-1][j]);
        }
        return min;
    }
}