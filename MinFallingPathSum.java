package day9;

//Time Complexity : O(n^2) where n is the number of row and column of 2D array 
//Space Complexity : O(1) where extra variables are 
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : to convert the solution obtained on paper into code 

public class MinFallingPathSum {
	public int minFallingPathSum(int[][] A) {
		int N = A.length;
		// This is a bottom up approach of solving the problem.
		// we start from second last row and first column. for every element in the second last row, 
		// keep on checking the elements of the last row and subsequent columns starting from 0;
		// decrement the row till we reach the topmost row
		for (int r = N - 2; r >= 0; --r) {
			
			// keep increasing the column
			for (int c = 0; c < N; ++c) {
				// best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
				// fist we take the element below that RC as minimum
				int best = A[r + 1][c];
				// if the column we are at is greater than 0, then we find the minimum between 
				// previous element and current minimum
				if (c > 0)
					best = Math.min(best, A[r + 1][c - 1]);
				// if the column we are at is less than last column, then we find the minimum between 
				// current minimum and next element 
				if (c + 1 < N)
					best = Math.min(best, A[r + 1][c + 1]);
				// we add the minimum element to the considered RC element.
				A[r][c] += best;
			}
		}
// here we find the minimum of the elements from the first row.
		int ans = Integer.MAX_VALUE;
		for (int x : A[0])
			ans = Math.min(ans, x);
		return ans;
	}
}
