// Time Complexity : O(m*n) where m and n are the dimensions of the given matrix
// Space Complexity : O(1) as we alter the matrix in place
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Could not solve it recursively


// Your code here along with comments explaining your approach


class minPathSum {

    public static int minFallingPathSum(int[][] A) {
        if (A.length == 0) return 0;
        int m = A.length, n = A[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j+1]);
                }
                else if (j == n-1) {
                     A[i][j] += Math.min(A[i-1][j], A[i-1][j-1]);    
                }
                else {
                    A[i][j] += Math.min(A[i-1][j-1], Math.min(A[i-1][j], A[i-1][j+1]));    
                }    
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (ans > A[m-1][i]) {
                ans = A[m-1][i];
            }   
        }
        return ans;
    }

	public static void main(String[] args) {
		int[][] A = new int[3][3];
		A[0][0] = 1;
		A[0][1] = 2;
		A[0][2] = 3;
		A[1][0] = 4;
		A[1][1] = 5;
		A[1][2] = 6;
		A[2][0] = 7;
		A[2][1] = 8;
		A[2][2] = 9;
		System.out.println(minFallingPathSum(A));
	}
}