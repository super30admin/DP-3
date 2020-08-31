// Time Complexity : O(N2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/*
    This is similar to Paint houses questions. At each iterations, we need to take min of previous rows
    values. We need to handle some edges like when j is 0 or A.length-1;
    Finally, we return the min of the last row elements.

*/
class Solution {
    public int minFallingPathSum(int[][] A) {
        for(int i=1; i< A.length; i++){
            for(int j=0; j< A.length; j++){
                if(j == 0){
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j+1]);
                }
                else if(j == A.length-1){
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j-1]);
                }
                else{
                    A[i][j] += Math.min(A[i-1][j+1], Math.min(A[i-1][j], A[i-1][j-1]));
                }
            }
        }
        //return Math.min(A[A.length-1][j+1], Math.min(A[i-1][j], A[i-1][j-1]));
        int min = Integer.MAX_VALUE;
        for(int j=0; j< A.length; j++){
            min = Math.min(min, A[A.length-1][j]);
        }
        return min;
        
    }
}