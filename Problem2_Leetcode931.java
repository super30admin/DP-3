// Time Complexity : O(MN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Solution: Using dp

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int n = matrix.length;

        // traverse the matrix from 2nd last row
        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < n; j++) {

                int belowLeft = Integer.MAX_VALUE;
                if(j - 1 >= 0) {
                    belowLeft = matrix[i + 1][j - 1];
                }

                int below = matrix[i + 1][j];

                int belowRight = Integer.MAX_VALUE;
                if(j + 1 < n)
                    belowRight = matrix[i + 1][j + 1];

                // calculate current matrix + min of belowLeft, below and belowRight
                matrix[i][j] = matrix[i][j] + Math.min(belowLeft, Math.min(below, belowRight));
            }
        }

        int min = Integer.MAX_VALUE;

        // Your minimum will be in the first row
        for(int j = 0; j < n; j++) {
            min = Math.min(min, matrix[0][j]);
        }

        return min;
    }
}