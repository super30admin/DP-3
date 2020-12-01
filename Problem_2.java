// Minimum Falling Path Sum

// Time Complexity : O(M*N) where M is rows and N is columns
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes, Runtime: 3 ms and Memory Usage: 39.6 MB
// Any problem you faced while coding this : Initally yes, After class understanding no. But Cant solve using Python
// Your code here along with comments explaining your approach
// Approach
"""
After trying the greedy algorithm and recursive approach and being unsuccesful in finding the maximum points
Dynamic Approach is used by implementing a 2D array by taking the minimum out of the last row same column and last row adjacent column 
in the corners i.e [(i-1,j), (i-1,j-1)] or [(i-1,j), (i-1,j+1). In the middle part of the matrix using
three options to compare i.e [(i-1,j), (i-1,j-1), (i-1)(j+1)] thus finding the minimum
from the last row. This problem is similar to Paint House problem.

"""
class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A==null||A.length==0)
            return 0;
        for(int i=1;i<A.length;i++)
        {
            for(int j=0;j<A.length;j++)
            {
                if(j==0)
                {
                    A[i][j]+=Math.min(A[i-1][j],A[i-1][j+1]);
                }
                else if(j==A[0].length-1)
                {
                 A[i][j]+=Math.min(A[i-1][j],A[i-1][j-1]); 
                }
                else
                {
                    A[i][j]+=Math.min(A[i-1][j],Math.min(A[i-1][j-1],A[i-1][j+1]));
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int num:A[A.length-1])
        {
            min=Math.min(min,num);
        }
        return min;
        
    }
}