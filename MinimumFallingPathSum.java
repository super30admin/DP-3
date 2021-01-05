// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Take a bottom up approach to find the minimum path starting for the second last row of the matrix. Finally take the minimum from the first row.

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        if( A == null || A.length == 0) return -1;
        
        if( A.length == 1) return A[0][0];
        
        for(int i = A.length - 2; i >= 0; i-- ){ 
            
            for(int j = 0; j < A[0].length; j++){
                if(j == 0){
                    A[i][j] = min(A[i][j] + A[i+1][j] , A[i][j] + A[i+1][j+1]);
                }
                else if(j == A[0].length - 1){
                    A[i][j] = min(A[i][j] + A[i+1][j] , A[i][j] + A[i+1][j-1]);
                } else {
                    A[i][j] = min(A[i][j] + A[i+1][j-1], A[i][j] + A[i+1][j] , A[i][j] + A[i+1][j+1]);
                } 
            }
        }
        
        int min = A[0][0];
        
        for(int j = 1; j < A.length; j++){
            if(A[0][j] < min)
                min = A[0][j];
        }
        
        return min;
    }
    
    private int min(int a, int b){
        return Math.min(a,b);
    }
    
    private int min(int a, int b, int c){
        return Math.min(a,Math.min(b,c));
    }
}
