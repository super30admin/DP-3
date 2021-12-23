public class MinFallingSum {

    // TC : O(N2)
    // SC : O(1)
    public int minFallingPathSum(int[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return 0;

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                // if the item to be checked is in the first coloumn then only the next row's
                // below elment and right side element is checked
                if (j == 0) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                }
                // if the item is in the last coloumn, the left side and below element's value
                // is compared and minimum among those two are added.
                else if (j == col - 1) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                } else
                    matrix[i][j] = matrix[i][j]
                            + Math.min(matrix[i + 1][j], Math.min(matrix[i + 1][j - 1], matrix[i + 1][j + 1]));
            }
        }
        // looking for the minimum element in the first row
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            min = Math.min(min, matrix[0][i]);
        }
        return min;

    }
}