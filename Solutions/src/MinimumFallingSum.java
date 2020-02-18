// Time Complexity :O(n^2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class MinimumFallingSum {
    public int minFallingPathSum(int[][] A) {
        if (A==null || A.length==0){
            return 0;
        }

        int m = A.length;

        for (int i=1;i<m;i++){
            for(int j=0;j<m;j++){
                if(j==0){
                    A[i][j] += Math.min(A[i-1][j],A[i-1][j+1]);
                }
                else if(j==m-1){
                    A[i][j] += Math.min(A[i-1][j],A[i-1][j-1]);
                }
                else{
                    A[i][j] += Math.min(A[i-1][j],Math.min(A[i-1][j-1],A[i-1][j+1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i =0;i<m;i++){
            min = Math.min(min,A[m-1][i]);
        }
        return min;
    }
}
