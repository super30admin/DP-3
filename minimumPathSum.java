// for approch 1
// Time Complexity : O(2^n*n)
// Space Complexity : O(n*n + n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// for approch 2
// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {

    // approch 1
    private static int helper(int[][] matrix, int row, int col, int minCount) {
        // if column is less than 0 or greater then last column we returne max value;
        if (col < 0 || col >= matrix[0].length)
            return Integer.MAX_VALUE;
        // if row is at end of the matrix we return maxCount
        if (row == matrix.length)
            return minCount;
        // logic

        // for every matrix[row][col] we get down as per condition given and check
        // minimum value;
        return Math.min(helper(matrix, row + 1, col + 1, minCount + matrix[row][col]),
                Math.min(helper(matrix, row + 1, col, minCount + matrix[row][col]),
                        helper(matrix, row + 1, col - 1, minCount + matrix[row][col])));
    }

    public static int minFallingPathSum1(int[][] matrix) {

        // to store all the paths we can go from first row
        int[] temp = new int[matrix[0].length];

        // to store final value;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < temp.length; i++) {

            // traverse through all the paths we can go from first row and store it in temp
            // array
            temp[i] = helper(matrix, 0, i, 0);
        }

        // get minimum paths
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] < min) {
                min = temp[i];
            }
        }

        // return minimum value;
        return min;
    }

    // ----------------------------------------------------------------------------------------------------
    // approch 2 dp
    public static int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        // to store min value;
        int min = Integer.MAX_VALUE;
        // dp table
        int[][] dp = new int[n][n];
        // store last row value into last row of dp table
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = matrix[n - 1][i];
        }

        // traverse from second last row of matrix and get minimum values that can be
        // add from next row as per given condition
        for (int i = n - 2; i >= 0; i--) {

            // traverse through column
            for (int j = 0; j < n; j++) {

                // if col = 0 than we do not have to check col -1;
                if (j == 0) {
                    dp[i][j] = Math.min(matrix[i][j] + dp[i + 1][j], matrix[i][j] + dp[i + 1][j + 1]);
                    // if col is last than we do not have to check col + 1;
                } else if (j == n - 1) {
                    dp[i][j] = Math.min(matrix[i][j] + dp[i + 1][j], matrix[i][j] + dp[i + 1][j - 1]);
                } else {
                    // else we check col + 1, col -1 and same col
                    dp[i][j] = Math.min(matrix[i][j] + dp[i + 1][j],
                            Math.min(matrix[i][j] + dp[i + 1][j - 1], matrix[i][j] + dp[i + 1][j + 1]));

                }
            }
        }

        // to get min value from first column
        for (int i = 0; i < n; i++) {
            if (dp[0][i] < min) {
                min = dp[0][i];
            }
        }
        return min;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 2, 1, 3 },
                { 6, 5, 4 },
                { 7, 8, 9 }
        };
        System.out.println("minimum falling Path is: " + minFallingPathSum1(matrix));
        System.out.println("minimum falling Path is: " + minFallingPathSum2(matrix));

    }
}