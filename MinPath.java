// Time Complexity : 0(rows*cols)
// Space Complexity : 0(rows*cols)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MinPath {
    public int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0 )
            return 0;
        if(A[0].length == 0)
            return 0;

        int rows = A.length;
        int cols = A[0].length;

        int[][] dp = new int[rows][cols+2];

        //copy first row
        for(int i=1;i<=cols;i++){
            dp[0][i] = A[0][i-1];
        }

        //put max value in first & last row
        for(int i=0;i<rows;i++){
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][cols+1] = Integer.MAX_VALUE;
        }

        //build dp
        for(int i=1;i<rows;i++){
            for(int j=1;j<=cols;j++){
                int minNeighbor = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                minNeighbor = Math.min(minNeighbor, dp[i - 1][j + 1]);
                dp[i][j] = A[i][j - 1] + minNeighbor;
            }
        }

        //find min from last row
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=cols;i++){
            min = Math.min(min, dp[rows-1][i]);
        }

        return min;
    }
}