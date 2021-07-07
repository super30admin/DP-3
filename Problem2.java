// Time Complexity :
//      m - size of A , n - size of each array 
//      minFallingPathSum() - O(m*n)
//      
// Space Complexity :
//      minFallingPathSum() - O(1)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minFallingPathSum(int[][] A) {
        //edge case
        if(A == null || A.length == 0)
            return 0;
        
        if(A[0] == null || A[0].length == 0)
            return 0;
        
        if(A[0].length == 1)
            return A[0][0];
        
        int m = A.length;
        int n = A[0].length;
        int minD = Integer.MAX_VALUE;
        
        for(int i=1; i < m ; ++i)
        {
            for(int j=0; j < n; ++j)
            {
                if(j == 0 || j == n-1)
                {
                    if(j == 0)
                    {
                        A[i][j] = A[i][j] + Math.min( A[i-1][j], A[i-1][j+1]);
                        
                        if(i == m-1 && A[i][j] < minD)
                        {
                            minD = A[i][j];
                        }
                    }
                    else
                    {
                        A[i][j] = A[i][j] + Math.min(A[i-1][j-1],A[i-1][j]);
                        
                        if(i == m-1 && A[i][j] < minD)
                        {
                            minD = A[i][j];
                        }
                    }
                }
                else
                {
                    A[i][j] = A[i][j] + Math.min( Math.min(A[i-1][j-1],A[i-1][j]), A[i-1][j+1]);
                    
                    if(i == m-1 && A[i][j] < minD)
                    {
                        minD = A[i][j];
                    }
                }
            }
            
        }
        
        return minD;
    }
}