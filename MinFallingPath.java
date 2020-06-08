// Time Complexity : O(m*n) where m is number of rows and n is number of columns of A
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinFallingPath {
    public int minFallingPathSum(int[][] A) {
        
        if(A == null || A.length==0) return 0;
        
        for(int i=1;i<A.length;i++)
        {
            for(int j=0;j<A[0].length;j++)
            {
                int min = A[i-1][j];
                if(j-1>=0) min = Math.min(min,A[i-1][j-1]);
                if(j+1<=A[0].length-1) min = Math.min(min,A[i-1][j+1]);
                A[i][j] +=min;
            }
        }
        int min = 0;
        for(int i=0;i<A[0].length-1;i++)
        {
            A[A.length-1][i+1] = Math.min(A[A.length-1][i],A[A.length-1][i+1]);
        }
        return A[A.length-1][A[0].length-1];
    }
}