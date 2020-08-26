class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A==null || A.length==0) return 0;
        int min=Integer.MAX_VALUE;
        int n=A.length;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j==0)
                {
                    A[i][j]=A[i][j]+Math.min(A[i-1][j],A[i-1][j+1]);                    
                }
                else if(j==n-1)
                {
                    A[i][j]=A[i][j]+Math.min(A[i-1][j],A[i-1][j-1]);
                }
                else{
                    A[i][j]=A[i][j]+Math.min(A[i-1][j],Math.min(A[i-1][j-1],A[i-1][j+1]));
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            min=Math.min(min,A[n-1][i]);
        }
        return min;
    }
}