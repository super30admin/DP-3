package DP3;
//Time Complexity : o(m*n) 
//Space Complexity :o(m*n) 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :No

//Your code here along with comments explaining your approach


public class MinimumFallingPathSumDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = {{2,1,3} , {6,5,4}, {7,8,9}};
		
		int minCost = minimumFallingPathSumRecursive(matrix);
		
		System.out.println(minCost);
	}
	private static int minimumFallingPathSumRecursive(int[][] matrix) {

		 if(matrix == null || matrix.length == 0) return 0;
	        int n = matrix.length;
	        for(int i = 1; i < n; i++){
	            for(int j = 0; j < n; j++){
	                // j == 0 consider two upper element
	                if(j == 0){
	                	matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], matrix[i-1][j+1]);
	                } else if(j == n -1){
	                	matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], matrix[i-1][j-1]);
	                } else {
	                	matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j], matrix[i-1][j+1]));
	                }
	            }
	        }
	        int min = Integer.MAX_VALUE;
	        for(int i = 0; i < n; i++){
	            min = Math.min(min, matrix[n-1][i]);
	        }
	        return min;
	    }
}
