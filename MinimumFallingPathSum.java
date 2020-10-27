// Time Complexity : O(n^2) where n is size of the the array
// Space Complexity : O(1), no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Approach
 * We see the repetitive sub problem, we can used DP approach to optimally solve the problem
 * We are suing the Bottom up approach, where to select the value of A[i][j] we take
 * min of(A[i+1][j-1], A[i+1][j],A[i+1][j+1]
 * */


public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] A) {
        //edge
        if(A==null || A.length==0) return 0;
        int n = A.length;
        for(int i = n-2; i>=0; i--){
            for(int j=0; j<n; j++){
                if(j==0){
                    A[i][j] += Math.min(A[i+1][j], A[i+1][j+1]);
                }
                else if(j==n-1){

                    A[i][j] += Math.min(A[i+1][j-1], A[i+1][j]);
                }
                else {
                    A[i][j] += Math.min(A[i+1][j-1], Math.min(A[i+1][j], A[i+1][j+1]));
                }
            }
        }

        int result = A[0][0];
        for(int i=1; i<n;i++){
            result = Math.min(result, A[0][i]);
        }
        return result;
    }
}