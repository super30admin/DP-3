// Time Complexity : O(N2) N square: 2*2 matrix iterated
// Space Complexity : O(1) : No extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't solve the problem by own


// Your code here along with comments explaining your approach: Same as class

class Solution {
    public int minFallingPathSum(int[][] A) {
        
        if(A == null || A.length == 0) return 0;
        
        int n = A.length;
        
        for(int i=1; i < A.length; i++){
            for(int j=0; j<A.length; j++){
                if(j == 0){
                    A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j+1]);
                }else if(j == n-1){
                    A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j-1]);
                }else{
                    A[i][j] = A[i][j] + Math.min(A[i-1][j-1], Math.min(A[i-1][j], A[i-1][j+1]));
                                                 
                                                 
                                                 }
                                                 }                                                                   
                                                 }
                
                                                 int min = Integer.MAX_VALUE;
                                                 for(int i=0; i<n; i++){
                                                     min = Math.min(min, A[n-1][i]);
                                                 }
                                                 return min;
                                                 }
                                                 }

