// Time Complexity :O(n^2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Similar to paint house problem

class Solution {
    public int minFallingPathSum(int[][] A) {
      //edge
        if(A == null || A.length == 0) return 0;
        
        for(int i = 1; i <A.length; i++){
            for (int j=0; j < A[0].length; j++){
                
                if(j==0){
                     A[i][j] += Math.min(A[i-1][j],A[i-1][j+1]);
                }                   
                
                else if(j== A[0].length-1){
                     A[i][j] += Math.min(A[i-1][j-1],A[i-1][j]);
                }                   
                //Pick from j-1,j,j+1
                else{
                    A[i][j] += Math.min(A[i-1][j], Math.min(A[i-1][j+1], A[i-1][j-1]));
                }
                    
            }
        }
            int min = Integer.MAX_VALUE;
            for(int j=0; j<A[0].length; j++){
                //Get minimum from last row
                min = Math.min(A[A.length-1][j],min);
            }
           return min;        
    }
         
}