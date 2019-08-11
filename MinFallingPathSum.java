/**
 * Time: O(n)
 * Space: O(n)
 * Leetcode Accepted: yes
 * Problems faced: NA
 */
public class MinFallingPathSum {	
	public static int minFallingPathSum(int[][] A) {
		 int n = A.length;
			int m = A[0].length;
	        int[][] dp = new int[A.length][A[0].length];
	        for(int j=0; j<m; j++) {
	        		dp[0][j] = A[0][j];
	        }
	        for(int i=1; i<n; i++) {
	        	 for(int j=0; j<m; j++) {
	        		 //Left most column has only two options
	             if(j==0) {
	            	 	dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
	            	 //Right most column has only two options
	             } else if(j==m-1) {
	            	 	dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
	            	 //All middle columns have 3 options	
	             } else {
	            	 	dp[i][j] = A[i][j] + Math.min(dp[i-1][j+1], Math.min(dp[i-1][j], dp[i-1][j-1]));
	             }
	         }
	        }
	   
	        int min = dp[n-1][0];
	        for(int j=1; j<m; j++) {
	        		min = Math.min(min, dp[n-1][j]);
	        }
	        return min;
    }
	public static void main(String[] args) {
		int[][] arr = {{-62,-63,23,31},{-5,-82,52,76},{85,69,80,85},{8,-22,41,-45}};
		System.out.println(minFallingPathSum(arr));
	}

}
