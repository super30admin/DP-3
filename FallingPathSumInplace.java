/**
 * Time complexity is O(n^2)
 * space complexity is O(n)
 */
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for(int i = rows-2; i >= 0; i--) {
            for(int j = 0; j < cols; j++) {
                if(j > 0 && j < cols-1 ) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j+1], Math.min(matrix[i+1][j], matrix[i+1][j-1]));
                }
                else if ( j == cols-1) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }
                else {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < cols; i++) {
            res = Math.min(res, matrix[0][i]);
        }
        return res;
    }
}