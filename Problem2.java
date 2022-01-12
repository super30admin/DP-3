// Time Complexity : O(m*n) number of rows*number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No Problems faced


// Your code here along with comments explaining your approach
public class Problem2 {
	public int minFallingPathSum(int[][] matrix) {
		 int leastPath = Integer.MAX_VALUE;
	        for(int i=matrix.length-2; i>=0; i--) {
	            for(int j = 0; j<=matrix[0].length-1; j++) {
	                if(j==0) {
	                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
	                } else if(j== matrix[0].length-1) {
	                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1], matrix[i+1][j]);
	                } else {
	                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j], matrix[i+1][j+1]));
	                }
	            }
	        }
	        
	        for(int j = 0; j<matrix[0].length; j++) {
	            leastPath = Math.min(leastPath, matrix[0][j]);
	        }
	        return leastPath;
    }
}
