//TimeComplexity: O(n*m) where n is the number of rows of A & m is columns of A
//Space Complexity: O(1)

class Solution {
    public int minFallingPathSum(int[][] A) {
        for(int i=1; i < A.length; i++)
        {
            for(int j=0; j<A[0].length; j++)
            {
                if(j-1>=0 && j+1<A[0].length)
                    A[i][j] += Math.min(Math.min(A[i-1][j], A[i-1][j+1]), A[i-1][j-1]);
                else if(j-1>=0)
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j-1]);
                else if (j+1<A[0].length)
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j+1]);
                else
                    A[i][j] += A[i-1][j];
            }
        }
        int min = Integer.MAX_VALUE;
        int i = A.length -1;
        for(int j=0; j<A[0].length; j++)
        {
            min = Math.min(min, A[i][j]);
        }
        return min;
    }
}