/**
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                //First column
                if(j == 0) {
                    matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                } else if (j == m-1) { //Last column
                    matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                } else { // All other columns
                    matrix[i][j] += Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i-1][j+1]));
                }
            }
        }
        
        //Finding the optimum solution
        //Consider the last row of the matrix array.
        int min = Integer.MAX_VALUE;
        for(int x: matrix[n-1]) {
            if(x < min) {
                min = x;
            }
        }
        return min;
    }
}
