// Time Complexity : O(N^2), A is a square matrix with N rows and columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] A) {
        
        if(A == null || A.length == 0 ) return 0;
        
        int n = A.length;
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                
                if(j == 0) {
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j+1]);
                } else if(j == n-1) {
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j-1]);
                } else {
                    A[i][j] += Math.min(A[i-1][j], Math.min(A[i-1][j-1], A[i-1][j+1]));
                }
            }
            
        }
        int min = Integer.MAX_VALUE;
        
        for(int num: A[n - 1]) {
            min = Math.min(min, num);
        }
        
        return min;
    }
}