//Time Complexity: O(m*n) - m is the no. of rows, n is the no. of columns.
//Space Complexity: O(n) 
//Code run successfully on LeetCode.

public class Problem2_DP_2 {
	
	 public int minFallingPathSum(int[][] matrix) {
		 
		 if(matrix == null|| matrix.length == 0)
			 return -1;
		 
		 int m = matrix.length;
		 int n = matrix[0].length;
		 int min = Integer.MAX_VALUE;
		 
		 int[] dp = new int[n];
		 int[] row = new int[n];
		 
		 for(int i =0; i <n; i++)
			 dp[i] = matrix[m-1][i];
		 
		 for(int i = m-2; i >=0; i--) {
			 for(int j =0; j < n; j++) {
				 
				 if(j ==0)
					 row[j] = Math.min(dp[j], dp[j+1]) + matrix[i][j];
				 else if(j == n-1)
					 row[j] = Math.min(dp[j], dp[j-1]) + matrix[i][j];
				 else
					 row[j] = Math.min(dp[j], Math.min(dp[j+1], dp[j-1])) + matrix[i][j];
			}
			 
			for(int j =0; j < n; j++)
				dp[j] = row[j];
		 }
	     
		 for(int j=0; j<n; j++) {
			 if(dp[j] < min)
				 min = dp[j];
		 }
		 
		 return min;
	    }

}
