// Time Complexity : O(M * N) where M = #Rows and N = #Cols
// Space Complexity : O(M * N) for caching and O(M) for recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    private static int[][] memo;
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix[0].length == 0)
        {
            return 0;
        }
        
        memo = new int[matrix.length][matrix[0].length];
        
        for(int[] arr: memo)
        {
            Arrays.fill(arr, -1);
        }
        
        int minSum = Integer.MAX_VALUE;
        for(int c = 0; c < matrix[0].length; c++)
        {
            minSum = Math.min(minSum, helper(matrix, 0, c));
        }
        
        return minSum;
    }
    
    private int helper(int[][] mat, int pR, int pC)
    {
        if(pR == mat.length - 1 && (pC >= 0 && pC < mat[pR].length))
        {
            return mat[pR][pC];
        }
        if(pR < 0 || pR >= mat.length || pC < 0 || pC >= mat[pR].length)
        {
            return (int)1e9;
        }
        if(memo[pR][pC] != -1)
        {
            return memo[pR][pC];
        }
        
        int s1 = helper(mat, pR + 1, pC);
        int s2 = helper(mat, pR + 1, pC + 1);
        int s3 = helper(mat, pR + 1, pC - 1);
        
        int ans = mat[pR][pC] + Math.min(s1, Math.min(s2, s3));
        memo[pR][pC] = ans;
        
        return ans;
    }
}