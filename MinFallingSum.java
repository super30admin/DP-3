class MinFallingSum {
    public int minFallingSum(int[][] A) {
        //O(n^2 time and o(1) space
        if(A == null || A.length == 0) return 0;
        int size = A.length;
        for(int i = 1; i < size; i++){
            for(int j = 0; j < size; j++){
                if(j == 0){
                    A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j+1]);
                } else if(j == size -1){
                    A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j-1]);
                } else {
                    A[i][j] = A[i][j] + Math.min(A[i-1][j-1],Math.min(A[i-1][j], A[i-1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < size; i++){
            min = Math.min(min, A[n-1][i]);
        }
        return min;
    }
}