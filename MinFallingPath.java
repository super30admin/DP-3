// Time Complexity o(m*n) Space Complexity o(m*n);
class Solution {
    public int minFallingPathSum(int[][] matrix) {
     int[][] dp =  new  int[matrix.length][matrix[0].length];
     int r=  matrix.length;
     int c= matrix[0].length;
     for(int j=0;j<c;j++){
         dp[0][j] = matrix[0][j];
     } 
     for(int i=1;i<r;i++){
         for(int j=0;j<c;j++){
             if(j==0){
                 dp[i][j] = matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
             }
             else if(j==c-1){
                 dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
             }
             else{
                dp[i][j]=matrix[i][j]+Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i-1][j+1]); 
             }
         }
     }
     int min=99999;
     for(int j=0;j<c;j++){
         if(min>dp[r-1][j]){
             min=dp[r-1][j];
         }
     }
     return min;
    }
}
