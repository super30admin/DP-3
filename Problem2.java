/**
 * Time complexity - O(m*n)
 * Space complexity - O(1)
 * All test cases passed
 */
class Solution {
    public int minFallingPathSum(int[][] A) {
        for(int i=A.length-2; i>=0; i--)
        {
            for(int j=0; j<A[0].length; j++)
            {
                //check A[i+1][j-1] A[i+1][j] A[i+1][j+1]
                int currPrev = A[i+1][j];
                int mini = Integer.MAX_VALUE;
                if(j+1<A[0].length)
                    mini=Math.min(currPrev,A[i+1][j+1]);
                if(j-1>=0&&j+1<A[0].length)
                    mini=Math.min(mini,A[i+1][j-1]);
                if(j-1>=0&&j+1>=A[0].length)
                    mini=Math.min(currPrev,A[i+1][j-1]);
                A[i][j] = A[i][j]+mini;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int k=0; k<A[0].length; k++)
        {
            min=Math.min(min,A[0][k]);
        }
        return min;
    }
}