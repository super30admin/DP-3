//Time Complexity: O(M x N)
//Space Complexity: O(1)

//Approach: Dynamic Programming with Mutation

class MinFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0) return 0;
        
        for(int i = A.length - 2; i >= 0; i--)
        {
            for(int j = 0; j < A[0].length; j++)
            {
                if(j == 0)
                    A[i][j] = A[i][j] + Math.min(A[i+1][j], A[i+1][j+1]);
                else if(j == A[0].length - 1)
                    A[i][j] = A[i][j] + Math.min(A[i+1][j], A[i+1][j-1]);
                else
                    A[i][j] = A[i][j] + Math.min(A[i+1][j], Math.min(A[i+1][j+1], A[i+1][j-1]));
            }
            
        }
        
        int min = Integer.MAX_VALUE;;
        for(int i = 0 ; i < A[0].length; i++)
        {
            min = Math.min(min, A[0][i]);
        }
        return min;
    }
}