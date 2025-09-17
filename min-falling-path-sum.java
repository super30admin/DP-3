class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //base case
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        for (int i = n - 2; i >= 0; i--) {//we are trying getting the minimum value in a bottom up approach
            for (int j = 0; j < n; j++) {//checking rows
                if (j == 0) {//edge case on left
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                } else if (j == n - 1) {//edge case on right
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                } else {
                    matrix[i][j] = matrix[i][j]
                            + Math.min(matrix[i + 1][j], Math.min(matrix[i + 1][j + 1], matrix[i + 1][j - 1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, matrix[0][j]);
        }
        return min;
    }
}

//TC:O(n^2)
//SC:O(1)