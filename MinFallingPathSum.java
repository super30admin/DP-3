//Time Complexity :O(MN) where M,N is the row and column of given matrix
//Space Complexity :O(N) where N is the column of the given matrix
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this : No 


public class MinFallingPathSum {
	
	public int minFallingPathSum(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        // It will single array because we have just one changing parameter in recusive solution
        int[] dp = new int[col];
       
       // Populate first row  
        for(int i=0;i<col;i++){
            dp[i] = matrix[0][i]; 
            }
             int prev =0,curr=0;
       
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
               curr = dp[j];
                if(j==0){
                dp[j] = Math.min(curr,dp[j+1])+matrix[i][j];
                }
                else if(j==col-1){
                 dp[j] = Math.min(prev,curr)+matrix[i][j];
                }
                else{
                dp[j] = Math.min(dp[j+1],Math.min(prev,curr))+matrix[i][j];
                }
                prev = curr;
            }

        }
         int min = Integer.MAX_VALUE;
        for(int i=0;i<col;i++){
            min = Math.min(min,dp[i]);
        }
        return min;

    }
}
