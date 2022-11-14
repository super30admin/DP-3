// Time Complexity : O(3^row)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

public class Problem2 {
    public static Integer[][] memo;
    public static int minSum;

    public static int minFallingPathSum(int[][] matrix) {
        minSum = Integer.MAX_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        memo = new Integer[m][n];
        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum, dp(matrix, 0, i));
        }
        return minSum;
    }

    public static int dp(int[][] matrix, int row, int col) {
        // base
        if (col < 0 || col == matrix.length)
            return Integer.MAX_VALUE;

        if (row == matrix.length - 1)
            return matrix[row][col];

        if (memo[row][col] != null) {
            return memo[row][col];
        }

        // recurse
        memo[row][col] = matrix[row][col] +
                Math.min(dp(matrix, row + 1, col), Math.min(dp(matrix, row + 1, col - 1),
                        dp(matrix, row + 1, col + 1)));

        return memo[row][col];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        int minSum = minFallingPathSum(matrix);
        System.out.println(minSum);
    }
}
