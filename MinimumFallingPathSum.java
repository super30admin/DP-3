// Time Complexity : O(MN) M-> number of rows, N-> number of columns. Here it's a square matrix, M=N therefore O(N^2) 
// Space Complexity : O(1) Since no auxiliary space is used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class MinimumFallingPathSum{
	
	public int getMinimumFallingPathSum(int[][] A) {
		
        //Base case: checking whether the input array A is empty or not
		if(A==null || A.length==0) {
			return 0;
		}
		
        //filling in the array A 
		for(int i=1;i<A.length;i++) {
			for(int j=0;j<A[0].length;j++) {
				
                // if it's a first column, then consider first and second column of previous row
				if(j==0) {
					A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j+1]);
				}
                //if it's not both first and last column then consider the current, current-1 and current+1 columns of previous row

				if(j !=0 && j != A[0].length-1) {
					A[i][j] = A[i][j] + Math.min(A[i-1][j-1],Math.min(A[i-1][j], A[i-1][j+1]));
				}
                // if it's a last column, then conider last column and one but last column of previous row
				if(j==A[0].length-1) {
					A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j-1]);
				}
			}
		}

        //finding the minimum among the elements in the last row
		int lastRow = A.length-1;
		int min = Integer.MAX_VALUE;
		for(int j=0;j<A[0].length;j++) {
			if(A[lastRow][j]<=min) {
				min = A[lastRow][j];
			}
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		MinimumFallingPathSum ob = new MinimumFallingPathSum();
		int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(ob.getMinimumFallingPathSum(nums));
	}