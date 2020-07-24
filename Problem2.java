// Time Complexity : O(mn) m=rows, n=col
// Space Complexity : O(1) using the same matrix
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] A) {
        int min;
        
        for(int i=1; i<A.length; i++){
            for(int j=0; j<A[0].length; j++){
                int l = j-1;
                int r = j+1;
                if(l<0) l = 0;
                if(r>=A[0].length) r = A[0].length-1;
                
                min = Integer.MAX_VALUE;
                
                for(int k=l; k<=r; k++){
                    if(A[i-1][k]<min)
                        min = A[i-1][k];
                }
                
                A[i][j] += min;
            }    
        }
        
        min = Integer.MAX_VALUE;
        for(int j=0; j<A[0].length; j++){
            if(A[A.length-1][j]<min)
                min = A[A.length-1][j];
        }
        
        return min;
    }
}