// Time Complexity : O(n*m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null) return 0;
        int n = matrix.length; // number of rows
        int m = matrix[0].length; // number of colomns
        int min = Integer.MAX_VALUE;

        for (int i=n-2; i>=0; i--) {
            for (int j=0; j<m; j++) {
                // Case 1: There is no left element in the row below
                if (j==0) {
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }
                // Case 2: There is no right element in the row below
                else if (j == m-1) {
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }
                // Case 3: There is left and right element in the row below
                else {
                    matrix[i][j] += Math.min(matrix[i+1][j], Math.min(matrix[i+1][j-1], matrix[i+1][j+1]));
                }
            }
        }

        // Min in the first row
        for (int i=0; i<m; i++) {
            min = Math.min(min, matrix[0][i]);
        }

        return min;
    }
}