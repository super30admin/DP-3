public class Problem2 {
    //Time Complexity O(n*k)
    // Space Complexity O(K)
    // where n = raw and k = column
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == 0) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                } else if (j == n - 1) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                } else {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], (Math.min(matrix[i + 1][j - 1], matrix[i + 1][j + 1])));
                }
            }
        }
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.min(matrix[0][i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        int[][] matrix = {{2, 1, 3, 4}, {6, 5, 4, 5}, {7, 8, 9, 6}};
        int[][] matrix1 = {{2, 1}, {6, 5}, {7, 8}};
        int[][] matrix2 = {{-80, -13, 22}, {83, 94, -5}, {73, -48, 61}};
        int result = problem2.minFallingPathSum(matrix1);
        System.out.println("Final value " + result);
    }
}
