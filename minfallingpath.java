//TC: O(N)
//SC: O(M)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int i=row-2; i>=0; i--) {
            for(int j=0; j<col; j++) {                
                if(j == 0) {
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }else if(j == col-1) {
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }else {
                    matrix[i][j] += Math.min(matrix[i+1][j], Math.min(matrix[i+1][j-1], matrix[i+1][j+1]));
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int j=0; j<col; j++) {
            min = Math.min(min, matrix[0][j]);
        }
        return min;
    }
}