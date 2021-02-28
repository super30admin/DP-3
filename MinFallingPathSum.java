// This problem is similar to house paint problem. I'm constructing a dp array, and for each element I'm choosing the min element that i 
// could choose from the previous row in the matrix 
// Then out last row of the dp array will have the min possible sum and return the min of those. 

// Time Complexity : O(m*n), where m is the number of rows and n is the number of columns 
// Space Complexity : O(m*n), where m is the number of rows, and n is the number of columns

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinFallingPathSum {

    public static int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0] = matrix[0];

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == n - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
                }
                dp[i][j] += matrix[i][j];
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[m - 1][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        List<int[][]> inputs = new ArrayList<>();
        Collections.addAll(inputs, new int[][] { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } },
                new int[][] { { -19, 57 }, { -40, -5 } }, new int[][] { { -48 } });

        for (int[][] matrix : inputs) {
            System.out.println(minFallingPathSum(matrix));
        }
    }
}