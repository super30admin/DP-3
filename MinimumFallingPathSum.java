// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int n=matrix.length;
        int m=matrix[0].length;

        for(int i=n-2; i>=0;i--){
            for(int j=0; j<m;j++){
                if(j==0){
                    matrix[i][j]+= Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }
                else if(j==m-1){
                    matrix[i][j]+= Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }
                else{
                    matrix[i][j]+= Math.min(matrix[i+1][j+1],Math.min(matrix[i+1][j], matrix[i+1][j-1]));
                }
            }
        }
        int min= Integer.MAX_VALUE;
        for(int j=0; j<m;j++){
            min= Math.min(min, matrix[0][j]);
        }
        return min;
    }

}