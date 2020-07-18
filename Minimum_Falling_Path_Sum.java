// Time Complexity : O(m*n) ; the size of matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* A falling path starts from any element in the first row, and chooses one element from each row
 * The next row's choice must be in a column that is different from the previous row's column by at most one
 * Similar to paint house, each element is added with previous row min element eligible
 * Return the minimum from last row*/

public class Minimum_Falling_Path_Sum {
	public static int minFallingPathSum(int[][] A) {
		int[][] dp = new int[A.length][A.length]; 	// size of matrix
		
		for(int i=0; i<A.length; i++)
			dp[0][i] = A[0][i];			// inserting the elements to first row
		
		
		for(int i=1; i<A.length; i++) {
			for(int j=0; j<A.length; j++) {
				if(j == 0) 		// case1, if column's first value is 0, then add the element with min (previous row , previous row +1 element)
					dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
				
				else if(j == A.length-1)	// case2, choosing last value, then add the element with min (previous row , previous row -1 element)
					dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
				
				else		//else, choosing middle value, then add the element with min (previous row, previous row -1, previous row +1 element)
					dp[i][j] = A[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1]));
			}
		}
		
		// return the min of last row
		int min = Integer.MAX_VALUE;
		for(int i=0; i<A.length; i++) {
			if(min > dp[A.length-1][i])
				min = dp[A.length-1][i];
		}
		return min;
	}

	public static void main(String[] args) {
		int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.print(minFallingPathSum(A));

	}
}



/****************************************Recursive Approach***************************************/


//Time Complexity : O(n*3^m) - m : size of the rows, n : size of the column
//Space Complexity : O(m)

public class Minimum_Falling_Path_Sum {
	public static int minFallingPathSum(int[][] A) {
		int min = Integer.MAX_VALUE;
		for(int i=0;i<A.length;i++){
			min = Math.min(min,helper(A,0,i,0));
			}
		return min;
		}
	
	private static int helper(int[][] A, int i, int j, int min){
		if(i == A.length || j == A.length)
			return min;
		int minimum = Integer.MAX_VALUE;
		
		if(j==0)	// case1, if column's first value is 0, then add the element with min (previous row , previous row +1 element)
			minimum =Math.min(helper(A,i+1,j,min+A[i][j]),helper(A,i+1,j+1,min+A[i][j]));
		
		else if(j==A.length-1)	// case2, choosing last value, then add the element with min (previous row , previous row -1 element)
			minimum =Math.min(helper(A,i+1,j,min+A[i][j]),helper(A,i+1,j-1,min+A[i][j]));
		
		else	//else, choosing middle value, then add the element with min (previous row, previous row -1, previous row +1 element)
    	 minimum = Math.min(helper(A,i+1,j-1,min+A[i][j]),
                 Math.min(helper(A,i+1,j,min+A[i][j]),helper(A,i+1,j+1,min+A[i][j])));
		
		return minimum;
	}
	
	public static void main(String[] args) {
		int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.print(minFallingPathSum(A));

	}
}