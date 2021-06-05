// Time Complexity : O(n*n)
// Space Complexity : O(1) //used input to update as dp array 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/**
 * 1. Input array is used as DP multi dimensional array.
 * 2. For every row get the that row col price and add it with min of below row col,col-1,col+1 value. 
 * 3. At the end find min of first row.
 * 4. followed bottom up approach.
 */
public class MinimumFallingPathSum {
	public int minFallingPathSum(int[][] matrix) {
		
		int noOfRows = matrix.length;
		int noOfCols= matrix[0].length;
		
		for(int row = noOfRows-2; row >=0;row--) {
			for(int col= 0; col<noOfCols;col++) {
				matrix[row][col]=matrix[row][col]+getMin(matrix[row+1],col);
			}
		}
		
		return getMinInrow(matrix[0]);
	}
	private int getMin(int[] arr,int index) {
		if(index==0) {
			return Math.min(arr[index], arr[index+1]);
		}else if(index==arr.length-1) {
			return Math.min(arr[index], arr[index-1]);
		}else {
			return Math.min(arr[index], Math.min(arr[index-1],arr[index+1]));
		}
	}
	
	private int getMinInrow(int[] arr) {
		int min= arr[0];
		for(int i=1;i<arr.length;i++) {
			min = Math.min(min, arr[i]);
		}
		return min;
	}
	public static void main(String[] args) {
		
		int[][] arr= new int[][]{{2,1,3},{6,5,4},{7,8,9}};
		System.out.println(new MinimumFallingPathSum().minFallingPathSum(arr));
	}
}
