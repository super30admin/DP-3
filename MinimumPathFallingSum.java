// TC:O(N*N) -> N*N is the size of matrix A
// SC:O(1) -> No extra space is required.
// Did it run successfully on LeetCode? Yes
class Solution {
    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0) 
            return 0;
        
        for ( int i = A.length - 2; i >= 0; i--)
        {
            for ( int j = 0; j < A[0].length; j++)
            {
                int sum = A[i+1][j];
                if (j+1 < A[0].length)
                    sum = Math.min(sum, A[i+1][j+1]);
                if ( j > 0)
                    sum = Math.min(sum, A[i+1][j-1]);
                
                A[i][j] = A[i][j] + sum;
            }
        }
        
        int minSum = Integer.MAX_VALUE;
        for (int n : A[0])
        {
            minSum = Math.min(minSum, n);
        }
        return minSum;
}
}
