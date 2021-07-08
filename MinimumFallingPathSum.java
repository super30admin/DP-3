// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
no

// Your code here along with comments explaining your approach


class Solution {
    public int minFallingPathSum(int[][] A) {
    
        
        if(A == null || A.length == 0)
            return 0;
       
        if(A.length == 1)
           return A[0][0];
        int[][] dp = new int[A.length][A[0].length];
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0;i < A[0].length; i++){
            dp[0][i] = A[0][i];
        }
        
         for(int i = 1 ; i < A.length; i++){
             for(int j = 0; j < A[0].length ; j++ ){
                 
				 //if it is first column
                 if(j == 0){
                 dp[i][j] = Math.min(dp[i-1][0],dp[i-1][j+1]) + A[i][j];
                }
				//if it is last column
                 else if( j == A[0].length -1 ){
                     dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + A[i][j];
                 }
				 //if it is in the mid columns
                 else
                     dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1])) + A[i][j];
                     
             } 
         }
            
          for(int i  = 0 ;i<A[0].length; i++)
              min = Math.min(dp[A.length-1][i],min);
        
         return min;
            
        }
    }
    