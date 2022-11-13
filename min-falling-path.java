//Time complexity = o(n^2)
//Space complexity is O(1)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    // first col
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                } else if (j == matrix[0].length - 1) {
                    // last col
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                } else {
                    // mid
                    matrix[i][j] = matrix[i][j]
                            + Math.min(matrix[i + 1][j], Math.min(matrix[i + 1][j - 1], matrix[i + 1][j + 1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(matrix[0][i], min);
        }

        return min;
    }
}