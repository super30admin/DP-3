class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //I am thinking like a reverse pass that will put all the row minimums at the start of the row.
        
        //Nope, the above idea is wrong.
        
        //We need to do like a dfs may be.
        //What we will do is use like a 2d DP approach and do a reverse pass. We will compute the sums for all possible neighbors of a node and keep the min from that.
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int dp[][] = new int[rows + 1][cols + 1];
        
        for(int i = rows - 1; i >= 0; i--){
            
            for(int j = 0; j < cols; j++){
                
                //check the boundary conditions. 
                
                //Accordingly check the 3 possible below neighbors.
                
                //if they are 1st and last columns then only 2 neighbors will get checked.
                
                if(j == 0){
                    
                    //The first round of mins is just going to be 0s.
                    
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + matrix[i][j];
                    
                }
                
                else if(j == cols - 1){
                    
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j - 1]) + matrix[i][j];
                    
                }
                
                else{
                    
                    //Now you have to choose min from all the 3 possible neighbors.
                    
                    dp[i][j] = Math.min(dp[i + 1][j - 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1])) + matrix[i][j];
                    
                }
                
            }
            
        }
                                                         
        //Now the min sum must be present somewhere in the first row, we need to go and find it by going over that row.
                                                         
        int min = Integer.MAX_VALUE;
                                                         
        for(int col_num = 0; col_num < cols; col_num++){
            min = Math.min(min, dp[0][col_num]);
        }
                                                         
        return min;
    }
}