// TC: O(M*N) where were traversing each row(M) and each column(N) elements of the array
// SC: O(1) since we are updating the already existing array

// We are updating the sum of minimum values of atmost element values of next row, same column, previous column and next column to the present row and column
// Once we have the best minimum of atmost column values from present row and column, we will append the values to the given 2D array.
// The given 2D array will first row will have the sum of values of columns, Since we are updating the sum from the last row. Once we know we have the values
// in the first row, we check for the minimum value in the first row and return that resultant value.


public class MinFallingPath {
	
	public int minimum_path(int[][] A) {
		
		int n = A.length;
		
		for(int r=n/2;r>=0;r--) {
			for(int c=0;c<n;c++) {
				
				int best = A[r+1][c];
				
				if(c>0)
					best = Math.min(best, A[r+1][c-1]);
				if(c+1<n)
					best = Math.min(best, A[r+1][c+1]);
				A[r][c] += best; // update the matrix with the sum of minimum value of next column value
			}
		}
		int res = Integer.MAX_VALUE;


		for(int x: A[0])
			res = Math.min(res, x);
		return res;
	}
	
	public static void main(String[] args) {
		MinFallingPath minfa = new MinFallingPath();
		int[][] A = {{1,2,3}, {4, 5, 6},{7,8,9}};
		System.out.println(minfa.minimum_path(A));
	}

}
