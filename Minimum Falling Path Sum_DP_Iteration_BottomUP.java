//Solution: Come from bottom of the matrix, as each element's min below it is independent of the element above it, so calculate the min possible for each element from bottom.
//TC: O(3*N*N)
//SC:O(N*N)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix.length];

        for(int j=0; j< matrix.length; j++){
            dp[matrix.length-1][j] = matrix[matrix.length-1][j];
        }

        for(int i= matrix.length-2; i>=0;i--){
            for(int j =0; j< matrix.length; j++){
                //compare the dp[i+1][j-1],dp[i+1][j],dp[i+1][j+1] ; j>=0 && j<=matrix.length-1
                int gain = matrix[i][j];
                if(j==0){
                    dp[i][j] = gain + Math.min(dp[i+1][j],dp[i+1][j+1]);
                }
                else if(j==matrix.length -1) dp[i][j] = gain + Math.min(dp[i+1][j-1],dp[i+1][j]);
                else dp[i][j] = gain + Math.min(dp[i+1][j-1],Math.min(dp[i+1][j],dp[i+1][j+1]));
            }

        }
        int min = Integer.MAX_VALUE;
        for(int i:dp[0])min=Math.min(min,i);
        return min;
    }

}
