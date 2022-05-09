
// Time Complexity : O(m*n) where m = ero and n = col 
// Space Complexity : O(n) where n = size of each row
// Did this code successfully run on Leetcode : yes
public class Falling {
    public int minFallingPathSum(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;    
        int[] dp = new int[cols]  ;  
        for(int i=0; i<cols; i++){
            dp[i]= matrix[rows-1][i];
        } 
        for(int i=rows-2; i>=0;i--){
                 int temp1 = 10000000;
                 int temp2 = 10000000;
            for(int j=0; j<cols;j++){
    
                if(j==0){
                    temp1= dp[0];
                    dp[0]= Math.min(dp[0],dp[1]) + matrix[i][j];
                }else if(j==cols-1){
                    dp[cols-1] = Math.min(dp[j],temp1)+ matrix[i][j];
                }else{
                    temp2 = dp[j];
                    dp[j] = Math.min(temp1, Math.min(dp[j],dp[j+1])) + matrix[i][j];
                    temp1 = temp2;
                }

            }
        }
    
        int min=dp[0];
        for(int i=1; i<dp.length; i++){
            min = Math.min(min,dp[i]);

        }
        return min;
                                  
}
}
