//Time Complexity- O(1)
//Space Complexity=O(n*m)
class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A==null||A.length==0)
        {
            return 0;
        }
        for(int i=1;i<A.length;i++)
        {
            for(int j=0;j<A.length;j++)
            {
                if(j==0)
                {
                    A[i][j]+=Math.min(A[i-1][j],A[i-1][j+1]);
                }
                else if(j==A.length-1)
                {
                    A[i][j]+=Math.min(A[i-1][j],A[i-1][j-1]);
                }
                else{
                    A[i][j]+=Math.min(Math.min(A[i-1][j],A[i-1][j-1]),A[i-1][j+1]);
                }
            }
        }
            int min=Integer.MAX_VALUE;
            for(int num:A[A.length-1])
            {
                if(num<min)
                {
                    min=num;
                }
            }
            return min;

        }
}