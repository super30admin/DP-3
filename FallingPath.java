public class FallingPath {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    matrix[i][j] += Math.min(matrix[i + 1][j + 1], matrix[i + 1][j]);
                } else if (j == matrix[0].length - 1) {
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                } else {
                    matrix[i][j] += Math.min(matrix[i + 1][j - 1], Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            min = Math.min(min, matrix[0][j]);
        }
        return min;
    }
}
