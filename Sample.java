## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)

// Time Complexity : 0(n^2) because there are two nested loops, and each iteration performs constant time operations
// Space Complexity : 0(1) because the algorithm modifies the input matrix in place and does not create any additional data structures


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {      // base case
            return 0;
        }
        int n = matrix.length;                   // length of a sqaure matrix
        
        for (int i = n - 2; i >= 0; i--) {           // iterating second last row
            for (int j = 0; j < n; j++) {           // iterating columns from 0 to n
                if (j == 0) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]); 
                }
                else if (j == n - 1) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                }
                else {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], Math.min(matrix[i + 1][j - 1], matrix[i + 1][j + 1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        
        for (int j = 0; j < n; j++) {
            min = Math.min(min, matrix[0][j]);
        }
        return min;
    }
}
