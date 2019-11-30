// Time Complexity : O(2^n)
// Space Complexity :O(2^n)
// Did this code successfully run on Leetcode : TLE

class Solution{	
	public int minFallingPathSum(int[][] A){
		
		int min = Integer.MAX_VALUE;
		int n = A.length;
		for(int j=0; j<n;j++){
			min = Math.min(min, helper(A, 0, j, A[0][j]));
		}
		return min;
		
	}
	
	private void helper(int[][] A, int i, int j, int currSum){
		int n = A.length;
		
		//base case
		if(j < 0 || j> n-1)
			return Integer.MAX_VALUE;
		if(i==n-1)
			return currSum;
		int d1 = helper(A, i+1, j+1, currSum + A[i][j]);
		int d2 = helper(A, i+1, j-1, currSum + A[i][j]);
		int d3 = helper(A, i+1, j, currSum + A[i][j]);
		
		return Math.min(Math.min(d1,d2), d3);
	}
}
// Time Complexity : O(n^2)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode : yes
// DP Solution
class Solution{
	public int minFallingPathSum(int[][] A){
		
		int min = Integer.MAX_VALUE;
		int n = A.length;
		
		
		int[][] dp = new int[n][n];
			
		for (int j=0; j< n; j++){
			dp[0][j] = A[0][j];
		}
		for (int i=1; i< n; i++){
			for (int j=0; j< n; j++){
				if(j==0){
					dp[i][j] = A[i][j] + Math.min(dp[i-1][j],dp[i-1][j+1]);
				}
				else if(j == n-1){
					dp[i][j] = A[i][j] + Math.min(dp[i-1][j],dp[i-1][j-1]);
				}
				else{
					dp[i][j] = A[i][j] + Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]), dp[i-1][j+1]);
				}
			}
			
		}
		for (int j=0; j< n; j++){
			if(min > dp[n-1][j]){
				min = dp[n-1][j];
			}
		}
		
		return min;
	}
}

