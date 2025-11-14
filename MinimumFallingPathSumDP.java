/*
 Approach: Minimum Falling Path Sum (Bottom-up Dynamic Programming)
 - Problem: Compute the minimum falling path sum by filling a DP table from the top row to the bottom.
 - For each cell dp[i][j], consider the three possible parents from previous row (j, j-1, j+1) and take the minimum.
 - This avoids recursion and directly computes results iteratively.

 Time Complexity: O(N^2) where N = matrix.length (we process each of the N*N cells once).
 Space Complexity: O(N^2) for the DP table. This can be optimized to O(N) by reusing a single previous-row array.
 LeetCode: https://leetcode.com/problems/minimum-falling-path-sum/ (Problem 931)
*/

public class MinimumFallingPathSumDP {

    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int caseTop;
                int caseLeft = Integer.MAX_VALUE;
                int caseRight = Integer.MAX_VALUE;
                if (j - 1 >= 0)
                    caseLeft = matrix[i][j] + dp[i - 1][j - 1];
                if (j + 1 < matrix.length)
                    caseRight = matrix[i][j] + dp[i - 1][j + 1];
                caseTop = matrix[i][j] + dp[i - 1][j];

                int min = Math.min(caseTop, Math.min(caseLeft, caseRight));
                dp[i][j] = min;
            }
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            min = Math.min(min, dp[matrix.length - 1][i]);
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumFallingPathSumDP().minFallingPathSum(new int[][]{{-19,57},{-40,-5}}));
        System.out.println(new MinimumFallingPathSumDP().minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));

    }
}
