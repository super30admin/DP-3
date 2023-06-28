// Time Complexity : O(N^2) as it is sqaure matrix
// Space Complexity : O(N^2) we use 2D DP array of size n+1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Our code effectively calculates the minimum falling path sum by dynamically programming the intermediate results using the dp array. By considering the three possible paths from the next row, it determines the minimum sum for each position in the matrix, ultimately finding the minimum sum for the entire falling path

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int dp[][] = new int[matrix.length + 1][matrix.length + 1];
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = 0; col < matrix.length; col++) {
                if (col == 0) {
                    dp[row][col] = Math.min(dp[row + 1][col], dp[row + 1][col + 1]) + matrix[row][col];
                } else if (col == matrix.length - 1) {
                    dp[row][col] = Math.min(dp[row + 1][col], dp[row + 1][col - 1]) + matrix[row][col];
                } else {
                    dp[row][col] = Math.min(dp[row + 1][col],
                            Math.min(dp[row + 1][col + 1], dp[row + 1][col - 1])) + matrix[row][col];
                }
            }
        }
        int minFallingSum = Integer.MAX_VALUE;
        for (int startCol = 0; startCol < matrix.length; startCol++) {
            minFallingSum = Math.min(minFallingSum, dp[0][startCol]);
        }
        return minFallingSum;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum obj = new MinimumFallingPathSum();
        int[][] nums = {
                { -19, 57 }, { -40, -5 }
        };

        int[][] nums1 = {
                { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 }
        };
        System.out.println("Minimum Sum is: " + obj.minFallingPathSum(nums));
        System.out.println("Minimum Sum is: " + obj.minFallingPathSum(nums1));

    }
}
