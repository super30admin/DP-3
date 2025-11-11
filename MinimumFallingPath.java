class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // Start from second last row, move upwards
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int down = matrix[i + 1][j];
                int downLeft = (j > 0) ? matrix[i + 1][j - 1] : Integer.MAX_VALUE;
                int downRight = (j < n - 1) ? matrix[i + 1][j + 1] : Integer.MAX_VALUE;

                matrix[i][j] += Math.min(down, Math.min(downLeft, downRight));
            }
        }

        // Minimum value in top row is the answer
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, matrix[0][j]);
        }

        return minSum;
    }
}

Time complexity : O(n²)
space complexity : O(1)