//tc=O(n2)
//sc=O(1)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        int n = matrix.length;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if(j == 0) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j] , matrix[i+1][j+1]);
                }
                else if (j == n - 1) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j] , matrix[i+1][j-1]);
                }
                else {
                    matrix[i][j] = matrix[i][j] + (Math.min(matrix[i+1][j] , Math.min(matrix[i+1][j-1], matrix[i+1][j+1])));
                }
            }
        }
            int min = matrix[0][0];
            for (int i = 0; i < n; i++) {
                min =  min > matrix[0][i] ? matrix[0][i] : min;
            }
            return min;
        }
}