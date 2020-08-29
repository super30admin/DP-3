// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A==null || A.length == 0)
            return 0;
        
        for(int i=1; i<A.length; i++){
            for(int j=0; j<A[0].length; j++){
                if(j==0){
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j+1]);
                }else if(j==A[0].length-1){
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j-1]);
                }else{
                    A[i][j] += Math.min(A[i-1][j-1], Math.min(A[i-1][j], A[i-1][j+1]));
                }    
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int num: A[A.length - 1]){
            if (num < min){
                min = num;
            }
        }
        return min;
        
    }
}