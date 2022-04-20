// Time Complexity : o(m * n)
// Space Complexity : o(m + n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// we start from n - 2 row and travel up seeing the elements in below row i
// classic simple dp problem.
// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                if(j == 0) {
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                }
                else if(j == n - 1) {
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                }
                else {
                    matrix[i][j] += Math.min(matrix[i + 1][j - 1], Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            min = Math.min(min, matrix[0][i]);
        }
        return min;
    }
}