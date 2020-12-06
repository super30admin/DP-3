class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A.length == 0 || A == null) {
            return -1;
        }
        int minimumSum = Integer.MAX_VALUE;
        for(int i = 1; i < A.length; i++) {
            for(int j  = 0 ; j < A[0].length; j++) {
            if(j == 0) {
                A[i][j] += Math.min(A[i-1][j], A[i - 1][j + 1]);
            } else if(j == A[0].length - 1) {
                 A[i][j] += Math.min(A[i-1][j], A[i - 1][j - 1]);
            } else {
            A[i][j] += Math.min(A[i-1][j], Math.min(A[i - 1][j - 1], A[i - 1][j + 1]));
            }
            }
        }
        
        for(int j = 0; j < A.length; j++) {
            if(A[A.length - 1][j] < minimumSum) {
                minimumSum = A[A.length - 1][j];
            }
        }
        return minimumSum;
    }
}