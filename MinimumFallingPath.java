/*In this program, we use dynamic programming to find the path of the matrix elements with minimum sum
* the time complexity of this implementation is O(n*n)*/
public class MinimumFallingPath {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = matrix[n-1][i];
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int min = dp[i+1][j];
                if (j > 0) min = Math.min(min, dp[i+1][j-1]);
                if (j < n-1) min = Math.min(min, dp[i+1][j+1]);
                dp[i][j] = matrix[i][j] + min;
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum, dp[0][i]);
        }
        return minSum;
    }
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        MinimumFallingPath minimum = new MinimumFallingPath();
        int minSum = minimum.minFallingPathSum(matrix);
        System.out.println("Minimum falling path sum: " + minSum);
    }
}
