
public class FallingSum {
	
	//	Time:  O(n^2) 
	//	Space O(1) no dp matrix
	//	LeetCode: yes

	public int minFallingPathSum(int[][] A) {
		int n = A.length;
		int min = Integer.MAX_VALUE;

		for(int i= 1; i < n ; i++){
			for(int j=0; j < n ; j++){
//				first column -> consider first and next column
				if(j==0){
					A[i][j]  = A[i][j] + Math.min(A[i-1][0] , A[i-1][1]);
//					last column -> consider last and last-1 column
				}else if(j == n-1){
					A[i][j]  = A[i][j] + Math.min(A[i-1][n-1] , A[i-1][n-2]);
//					else consider 3 j, j-1, j+1 columns
				}else {
					A[i][j]  = A[i][j] + Math.min( Math.min(A[i-1][j] , A[i-1][j-1]), A[i-1][j+1]);
				}
			}
		}
//Finding min from the last row
		for(int j=0 ; j < n ; j++){
			if(min > A[n-1][j])
				min= A[n-1][j];
		}


		return min;

	}
}
