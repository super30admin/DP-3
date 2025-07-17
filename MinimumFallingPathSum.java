/**
 Go from last but one row to top and calculate for each row. 
 Finally calculate the min in the first row for the answer
 This problems is paint house pattern.
 */

class Solution {
    public int minFallingPathSum(int[][] matrix) {

        if (matrix == null || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
    
        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                if (j == 0) {
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                } else if (j == n - 1) {
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                } else {
                    matrix[i][j] += Math.min(matrix[i + 1][j], Math.min(matrix[i + 1][j - 1], matrix[i + 1][j + 1]));
                }
            }
        }


        int min = matrix[0][0];
        for (int j = 1; j < n; ++j) {
            min = Math.min(min, matrix[0][j]);
        }

        return min;

    }
}