// Time Complexity : O(N^2)
// Space Complexity : O(N * 2) = O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // base case
        if (matrix == null) return 0;
        int n = matrix.length;

        for (int i = 1; i<n; i++) {
            for (int j=0; j <n; j++) {
                if(j == 0) {
                    matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                } else if (j == n-1) {
                    matrix[i][j] += Math.min(matrix[i-1][j-1], matrix[i-1][j]);
                } else {
                    matrix[i][j] += Math.min(matrix[i-1][j], Math.min(matrix[i-1][j-1], matrix[i-1][j+1]));
                }
            }
        }

        // find minimun
        int min = Integer.MAX_VALUE;
        for (int j=0; j<n; j++) {
            System.out.println("value:" + matrix[n-1][j]);
            min = Math.min(min, matrix[n-1][j]);
        }

        return min;
    }
}
