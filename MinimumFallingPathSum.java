/*
* Approach:
*  1. We start from row 1, keeping row 0 values are minimum.
*       
*  2. We check valid directions from row1 and take minimum of all valid directions,
        and add to current matrix value.
* 
*  3. As we move further, 
    we update the prev and try to calculate the curr row values.

    At last, we return the minuimum of all values in the last row.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n^2)
* 
* Space Complexity: O(n)
* 
*/

public class MinimumFallingPathSum {
    int[] directions = { -1, 0, 1 };

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int[] prev = new int[n];
        int[] curr = new int[n];

        for (int col = 0; col < n; col++)
            prev[col] = matrix[0][col];

        for (int row = 1; row < m; row++) {
            for (int col = 0; col < n; col++) {

                int minValue = Integer.MAX_VALUE;

                for (int direction : directions) {
                    int newCol = col + direction;

                    if (newCol >= 0 && newCol < n) {
                        minValue = Integer.min(minValue, prev[newCol]);
                    }
                }

                // if (minValue == Integer.MAX_VALUE)
                System.out.println(minValue);
                curr[col] = matrix[row][col] + minValue;
            }

            prev = curr;
        }

        int minSum = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++)
            minSum = Integer.min(minSum, prev[col]);

        return minSum;
    }
}
