public class Solution {
    public int MinFallingPathSum(int[][] A) {
        if(A == null || A.Length == 0)
        {
            return 0;
        }
        
        for(int i=1;i<A.Length;i++)
        {
        for(int j=0;j<A[0].Length;j++)
        {
            if(j==0)
            {
                A[i][j] += Math.Min(A[i-1][j],A[i-1][j+1]);
            }
            else if (j==A[0].Length-1)
            {
                A[i][j] += Math.Min(A[i-1][j],A[i-1][j-1]);
            }
            else
            {
                A[i][j] += Math.Min(A[i-1][j],Math.Min(A[i-1][j-1],A[i-1][j+1]));
            }
        }
        }
        
        int min = Int32.MaxValue;
        foreach(int i in A[A.Length-1])
        {
            min = Math.Min(min,i);
        }
        return min;
        
    }
}
