// Time Complexity : O(N.N) where size of input 2D array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// The falling path from upper layer can fall only on the same column or one column before to it or
// one column after it. So we calculate from top layer till the last layer. To calculate a value at index i, j,
// we need to consider only the values from previous layer at index, and at column j, j-1 or j+1. Once, we sum up the paths
// and store in the last row, we return the minimum of the values in the last row.

public class FallingPathSum {
    public int minFallingPathSum(int[][] A) {
        int row = A.length;
        int col = A[0].length;

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    A[i][j] += Math.min(A[i - 1][j], A[i - 1][j + 1]);
                } else if (j == col - 1) {
                    A[i][j] += Math.min(A[i - 1][j], A[i - 1][j - 1]);
                } else {
                    A[i][j] += Math.min(A[i - 1][j], Math.min(A[i - 1][j + 1], A[i - 1][j - 1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            min = Math.min(min, A[row - 1][i]);
        }

        return min;
    }
}
