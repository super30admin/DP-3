// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach 
// Similar to paint house problem
class Solution {
    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        if(m==0)
        return 0;
        for(int i=A.length-2;i>=0;i--)  // Starting with the second last row we move upwards 
        {
            for(int j=0;j<n;j++)
            {
                if(j==0) // if 1st column
                {
                    A[i][j]+=Math.min(A[i+1][j],A[i+1][j+1]);
                }else if(j==n-1) // if last column
                {
                    A[i][j]+=Math.min(A[i+1][j],A[i+1][j-1]);
                }else{
                   A[i][j]+=Math.min(Math.min(A[i+1][j],A[i+1][j-1]),A[i+1][j+1]); 
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int j=0;j<n;j++)
        {
            if(A[0][j]<min)
            {
                min = A[0][j];
            }
        }
        
        return min;
    }
}