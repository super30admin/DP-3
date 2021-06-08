// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public int minFallingPathSum(int[][] A) {
        //null case
        if(A == null || A.length == 0) return 0;
        
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < A.length; j++){
                // consider the above two elements
                if(j == 0){
                    A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j+1]);
                } else if(j == A.length -1){
                    A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j-1]);
                } else {
                    A[i][j] = A[i][j] + Math.min(A[i-1][j-1],Math.min(A[i-1][j], A[i-1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++){
            min = Math.min(min, A[A.length-1][i]);
        }
        return min;
    }
}