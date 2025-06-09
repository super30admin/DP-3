// Time Complexity : O(row*col)
// Space Complexity : O(row*col)
class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int dp[][] = new int[row][col];
        if(row==0){
            return 0;
        }
        for(int i=0;i<col;i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                int v1 = Integer.MAX_VALUE, v2 = Integer.MAX_VALUE, v3 = Integer.MAX_VALUE;
                if(j-1>=0)
                {
                    v1 = dp[i-1][j-1];
                }
                if(j+1<=col-1)
                {
                    v2 = dp[i-1][j+1];
                }
                v3 = dp[i-1][j];
                dp[i][j] = matrix[i][j]+Math.min(v1, Math.min(v2, v3));
            }
        }
        int minRes = Integer.MAX_VALUE;
        for(int i=0;i<col;i++){
            minRes = Math.min(minRes, dp[row-1][i]);
        }   
        return minRes;
    }
}
