
// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int min=Integer.MAX_VALUE;
        for(int i=m-2;i>=0;i--){  ////calculating the minimum cost from last but one row all the way up to first row.
            for(int j=0;j<m;j++){ 
                if(j>0&&j<m-1){
                    matrix[i][j] += Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1],matrix[i+1][j+1]));
                }else if(j==m-1){
                    matrix[i][j] += Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }else{
                    matrix[i][j] += Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }
            }
            
        }
        for (int x: matrix[0])
            min = Math.min(min, x);
        return min;
    }
}
