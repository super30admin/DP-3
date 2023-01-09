// Time Complexity = O(m*n)
// Space Complexity = O(m*n)


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            dp[matrix.length-1][i]=matrix[matrix.length-1][i];
        }
        System.out.println(matrix[0].length-1);

        for(int i=dp.length-2;i>=0;i--){
            for(int j=0;j<dp[0].length;j++){
                 int min = 0;
                if(j==0){
                   min = Math.min(dp[i+1][j],dp[i+1][j+1]);
                   dp[i][j]=matrix[i][j]+min;
                }else if(j==dp[0].length-1){
                   min = Math.min(dp[i+1][j],dp[i+1][j-1]);
                   dp[i][j]=matrix[i][j]+min;
                }else if(j!=0 && j!=dp[0].length-1){
     min = Math.min(dp[i+1][j], Math.min(dp[i+1][j+1],dp[i+1][j-1]));
                   dp[i][j]=matrix[i][j]+min;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            ans = Math.min(ans,dp[0][i]);
        }

        return ans;
    }
}