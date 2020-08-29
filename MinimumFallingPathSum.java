class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        // Time Complexity: O(n^2)
        // Space Complexity:   O(1);
        
        //Observation: Difference of the indices is atmost 1
        //  atmost implies can be 1, 0 and -1 also 
        //  (previous coloumn, current, next)
        
        
        if(A == null || A.length == 0 || A[0].length == 0)
            return 0;
        
        
        for(int j = 1; j < A.length; j++){
            for(int i = 0; i < A[0].length; i++){
                if(i == 0)                              //For 0th column, no previous column
                    A[j][i] += Math.min(A[j - 1][i], A[j-1][i+1]);
                else if( i == A[0].length - 1){         //For last column, no next column
                    A[j][i] += Math.min(A[j-1][i], A[j-1][i - 1]);
                } else
                    A[j][i] += Math.min(A[j-1][i-1], Math.min(A[j-1][i], A[j-1][i+1]));
            }
        }
        
        // Fetching the min sum of all values in temp
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < A[0].length; i++){
            if( A[A.length - 1][i] < min)
                min = A[A.length - 1][i];
        }
        return min;
    }
}
