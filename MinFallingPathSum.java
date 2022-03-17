// Time Complexity :O(n*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = 0; j < matrix[0].length; j++) {
                int cost = Integer.MAX_VALUE;
                if (j - 1 >= 0)
                    cost = Math.min(cost, matrix[i + 1][j - 1]);
                cost = Math.min(cost, matrix[i + 1][j]);
                if (j + 1 < matrix[0].length)
                    cost = Math.min(cost, matrix[i + 1][j + 1]);
                matrix[i][j] += cost;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            min = Math.min(min, matrix[0][j]);
        }
        return min;
    }
}