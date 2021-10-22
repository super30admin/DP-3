// Leetcode 931 Minimum Falling Path Sum
// Time -> O(mn)
// Space -> O(mn)

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
       int [][] dp = new int[matrix.length][matrix[0].length]; 
        
        for(int i=0; i<dp[0].length; i++){
            dp[0][i] = matrix[0][i];
        }
        
        int[][] indices = {{-1,-1}, {-1,0}, {-1,1}};
        
        for(int row=1; row<dp.length; row++){
            for(int col=0; col < dp[0].length; col++){
                
                int temp = Integer.MAX_VALUE ;
                for(int i=0; i<indices.length; i++){
                    if (row+indices[i][0]>=0 && col+indices[i][1]>=0 && col+indices[i][1]<dp[0].length){
                        temp = Math.min(temp, dp[row+indices[i][0]][col+indices[i][1]]);
                    }     
                }
                
                dp[row][col] = matrix[row][col] + temp;
            }
        }
        
        
        int result = Integer.MAX_VALUE;
        
        for(int i=0;i<dp[0].length;i++){
            if(dp[dp.length-1][i]<result){
                result = dp[dp.length-1][i];
            }
        }
        
        return result;
        
        
    }
}