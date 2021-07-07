//Time Complexity : O(n^2)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes  
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
/*
 * The given problem states a scenario wherein from any point i,j, one can either go to i+1, j-1 point, or i+1, j point or i+1, j+1 point.
 * From the three paths, we need to select the minimum sum.
 */

class MinFallingPathsum {
    public int minFallingPathSum(int[][] A) {
        //edge case
        if(A == null || A.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(j == 0) { //boundary condition
                    A[i][j] += Math.min(A[i-1][j+1], A[i-1][j]);
                }
                else if(j == A[0].length-1) { //boundary condition
                    A[i][j] += Math.min(A[i-1][j-1], A[i-1][j]);
                }
                else {
                    A[i][j] += Math.min(A[i-1][j], Math.min(A[i-1][j-1], A[i-1][j+1]));
                }
            }
        }
        for(int i = 0; i < A[0].length; i++) {
            min = Math.min(A[A.length-1][i], min);
        }
        return min;
    }
}