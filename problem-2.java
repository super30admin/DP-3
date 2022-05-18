// Time Complexity : O(n*n)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int min=Integer.MAX_VALUE;
        for(int j=0; j<dp.length; j++){
            dp[0][j]=matrix[0][j];
            min=Math.min(min, dp[0][j]);
        }
        if(dp.length==1) return min;
        else min=Integer.MAX_VALUE;
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(j!=0 && j!=dp[0].length-1){
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j], Math.min(dp[i-1][j-1],dp[i-1][j+1]));
                }
                else if(j==0){
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j], dp[i-1][j+1]);
                }
                else{
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
                if(i==dp.length-1)
                min=Math.min(min, dp[i][j]);
            }
        }
        return min;
    }
}
