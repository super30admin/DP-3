class Solution {
    public int minFallingPathSum(int[][] A) {
        //edge
        if(A == null || A.length == 0) return 0;
        int n = A.length;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                // j == 0 consider two upper element
                if(j == 0){
                    A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j+1]);
                } else if(j == n -1){
                    A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j-1]);
                } else {
                    A[i][j] = A[i][j] + Math.min(A[i-1][j-1],Math.min(A[i-1][j], A[i-1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min, A[n-1][i]);
        }
        return min;
    }
}