// Recursive TLE O(3^n) time, O(n) space
// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int m = matrix[0].length; // m cols
//         int min = Integer.MAX_VALUE;

//         for (int i = 0; i < m; i++) {
//             int val = helper(0, i, matrix);
//             min = Math.min(min, val);
//         }
//         return min;
//     }

//     public int helper(int row, int col, int[][] matrix) {
//         if (col < 0 || col >= matrix[0].length) return 9999; // large value

//         if (row == matrix.length) {
//             return 0;
//         }

//         int down = matrix[row][col] + helper(row + 1, col, matrix);
//         int downRight = matrix[row][col] + helper(row + 1, col + 1, matrix);
//         int downLeft = matrix[row][col] + helper(row + 1, col - 1, matrix);

//         return Math.min(down, Math.min(downRight, downLeft));
//     }
// }


// Top down O(n * n) time, O(n * n) space
// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         int min = Integer.MAX_VALUE;
//         int[][] dp = new int[n][n];

//         for (int[] row : dp) {
//             Arrays.fill(row, 9999);
//         }

//         for (int i = 0; i < n; i++) { // n x n but i here is n cols
//             int val = helper(0, i, matrix, dp);
//             min = Math.min(min, val);
//         }
//         return min;
//     }

//     public int helper(int row, int col, int[][] matrix, int[][] dp) {
//         if (col < 0 || col >= matrix[0].length) return 9999; // large value

//         if (row == matrix.length) {
//             return 0;
//         }

//         if (dp[row][col] != 9999) return dp[row][col];

//         int down = matrix[row][col] + helper(row + 1, col, matrix, dp);
//         int downRight = matrix[row][col] + helper(row + 1, col + 1, matrix, dp);
//         int downLeft = matrix[row][col] + helper(row + 1, col - 1, matrix, dp);

//         dp[row][col] = Math.min(down, Math.min(downRight, downLeft));
//         return dp[row][col];
//     }
// }

// Bottom up DP O(n*n) time, O(n*n) space
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int LARGE = 9999;
        int[][] dp = new int[n][n];

        for (int col = 0; col < n; col++) {
            dp[0][col] = matrix[0][col];
        }

        for (int row = 1; row < n; row++) { 
            for (int col = 0; col < n; col++) {
                int upValue = matrix[row][col] + dp[row-1][col];
                int upLeftValue = matrix[row][col] + ((col > 0) ? dp[row-1][col-1] : LARGE);
                int upRightValue = matrix[row][col] + ((col < n-1) ? dp[row-1][col+1] : LARGE);
                
                dp[row][col] = Math.min(upValue, Math.min(upLeftValue, upRightValue));
            }            
        }

        // get min from last row
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n-1][i]);
        }
        return min;
    }
}
