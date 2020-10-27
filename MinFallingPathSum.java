// Time Complexity : Latest soln O(N)
// Space Complexity : O(N) - No of elements same for brute force
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this: No

class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0) return 0;
        
        int n = A.length;
        int m = A[0].length;
        for(int i = n - 2 ; i >= 0;i--){
            for(int j = 0;j<m;j++){
                if(j == 0){
                    A[i][j] += Math.min(A[i+1][j], A[i+1][j+1]);    
                }
                else if (j == m - 1){
                    A[i][j] += Math.min(A[i+1][j], A[i+1][j-1]); //corner case, min from self and one neighbour
                }
                else{
                    A[i][j] += Math.min(A[i+1][j], Math.min(A[i+1][j-1],A[i+1][j+1])); //middle elements choose the min from  neighbours
                }
            }
            
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0;i<m;i++){
            result = Math.min(result, A[0][i]);
        }
        return result;
    }
    
}