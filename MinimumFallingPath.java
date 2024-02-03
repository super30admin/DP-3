//time, space complexity == O(m*n)
//The algorithm uses dynamic programming to calculate the minimum falling path sum.
//the dp array is filled iteratively, with each element representing the minimum falling path sum ending at that position.
//The recurrence relation for calculating dp[i][j] is based on the minimum values from the previous row (dp[i-1][j-1], dp[i-1][j], and dp[i-1][j+1]).
//The final result is obtained by finding the minimum value in the last row of the dp array.
class Solution {
    public int minFallingPathSum(int[][] matrix) {
       int m = matrix.length;           
       int n = matrix[0].length;
       int[][] dp = new int[m][n];
       for(int i =0;i<n;i++){
           dp[0][i] = matrix[0][i];
          // System.out.println(dp[0][i]);
       }
       for(int i=1;i<m;i++){
           for(int j=0;j<n;j++){
               if(j==0){
                   dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                   //System.out.println( dp[i][j]);
               }
               else if(j==n-1){
                   dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
               }
               else dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1],dp[i-1][j+1]));
           }
       }
       int min = Integer.MAX_VALUE;
       for(int i=0;i<n;i++){
           min = Math.min(min, dp[m-1][i]);
       }
       return min;
    }
}