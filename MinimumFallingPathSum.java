// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;

        for(int i = m-2; i >=0; i--){
            for(int j = 0; j < m; j++){
                //first col
                if(j == 0){
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }else if(j == m-1){
                    //last col
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }else {
                    matrix[i][j] += Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j], matrix[i+1][j+1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            min = Math.min(min, matrix[0][i]);
        }

        return min;
    }
}
