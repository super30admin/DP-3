//Time Complexity : O(m*n) - m is the no. of rows, n is the no. of columns
//Space Complexity : O(m*n)
//Code run successfully on LeetCode.

public class Problem2_DP_1 {
	
	public int minFallingPathSum(int[][] matrix) {
        
		if(matrix == null|| matrix.length == 0)
			return -1;
		
		int m = matrix.length;
		int n = matrix[0].length;
		int min = Integer.MAX_VALUE;
		
		int[][] dp = new int[m][n];
		
		for(int i =0; i < n; i++) {
			dp[m-1][i] = matrix[m-1][i];
		}
		
		for(int i = m-2; i>= 0; i--) {
			for(int j =0; j <n; j++) {
				
				if(j ==0)
					dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + matrix[i][j];
				else if(j == n-1)
					dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j-1]) + matrix[i][j];
				else
					dp[i][j] = Math.min(dp[i+1][j], Math.min(dp[i+1][j-1], dp[i+1][j+1])) + matrix[i][j];
			}
		}
		
		for(int i =0; i < n; i++){
			if(dp[0][i] < min)
				min = dp[0][i];
		}
		return min;
   }
	

}
