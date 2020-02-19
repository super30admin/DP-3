// Time Complexity : O(N^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/*
Approach:
========
1. Similar to paint house problem with NxN instead of Nx3
2. Falling paths can have consecutive columns differ by atmost 1. => possible options for [i][j] are from 
[i-1][j-1], [i-1][j] or [i-1][j+1]
3. So, value at [i][j] is going to be minimum of above 3 + itself
4. If j == 0 or j == length-1, then check edge cases for j-1 and j+1 respectively
5. Iterate through all possible sums in the last row to get final minimum falling path
*/


class Solution {
    public int minFallingPathSum(int[][] A) {
        if( A == null || A.length == 0) return 0;
        
        for(int i = 1; i < A.length; i++) {
           for(int j = 0; j < A[0].length; j++) {
               //If first column, skip checking from j-1
              if(j == 0)
                   A[i][j] += Math.min(A[i-1][j], A[i-1][j+1]);
              //If last column, skip checking from j+1
              else if(j == A[0].length - 1)
                   A[i][j] += Math.min(A[i-1][j-1], A[i-1][j]);
              //Pick from j-1,j,j+1 
               else
                   A[i][j] += Math.min(A[i-1][j], Math.min(A[i-1][j+1], A[i-1][j-1]));
           }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < A[0].length; j++) {
            //Get minimum of total sum from last row
            min = Math.min(A[A.length-1][j], min);
        }
        return min;
    }
}