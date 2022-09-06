// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution{
    public int minFallingPathSum(int[][] matrix) {

        //i = 0 start -> i++ => col-1, col, col+1 min check
        //add matrix value
        //return min(matrix[row-1][i]);

        int result = Integer.MAX_VALUE;
        int row = matrix.length;

        for(int i = 1; i < row; i++) {
            for(int j = 0; j < row; j++) {

                int lowBound = Math.max(0, j-1);
                int highBound = Math.min(j+1, row - 1);

                matrix[i][j] += Math.min(matrix[i-1][lowBound],
                        Math.min(matrix[i-1][j],
                                matrix[i-1][highBound]));
            }
        }

        for(int num : matrix[row-1]) {
            result = Math.min(num, result);
        }

        return result;
    }
}