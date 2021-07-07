package s30Coding;

//Time Complexity :- O(n^2) --- Traversing each element through first through row and then through column

//Space Complexity :- O(1)

// Logic :- Here we start with the 2nd last row and get the minimum element in the n+1th row and add it to the current value
//			Return the minimum number in the first row and that is the min Falling Path

public class MinFallingPathSum {
	public int minFallingPathSum(int[][] A) {
	       int N = A.length;
	        for (int r = N-2; r >= 0; r--) {
	            for (int c = 0; c < N; c++) {
	                // best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
	                int best = A[r+1][c];
	                if (c > 0)
	                    best = Math.min(best, A[r+1][c-1]);
	                if (c+1 < N)
	                    best = Math.min(best, A[r+1][c+1]);
	                A[r][c] += best;
	            }
	        }

	        int ans = Integer.MAX_VALUE;
	        for (int x: A[0])
	            ans = Math.min(ans, x);
	        return ans; 
	    }
}
