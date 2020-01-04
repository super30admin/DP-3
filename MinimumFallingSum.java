// Time Complexity : O(nk) n - length of the array k - number of elements at A[0]
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minFallingPathSum(int[][] A) {
        
        if(A == null || A.length == 0) return -1;
        
        int[][] dp = new int[A.length][A[0].length];

        int min = Integer.MAX_VALUE;
        
        return helper(A, dp, min);
        
    }
    
    private int helper(int[][] A, int[][] dp, int min){
        
        for(int i = 0; i < A.length; i++){

        	for(int j = 0; j < A[0].length; j++){
	
		        if(i == 0){
			        dp[i][j] = A[i][j];
		        }else{
		            if(j == 0){
			            dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
		            }else if(j == A[0].length - 1){
			            dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
		            }else{
			            dp[i][j] = A[i][j] + Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i-1][j+1]);
                    }
                }
                if(i == A.length -1){
                    min = Math.min(min, dp[i][j]);
                }
		    }
                                        
                                        
	    }                                        
        return min;       
    }
}