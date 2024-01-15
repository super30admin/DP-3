// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                int up = matrix[i-1][j];
                int left = j > 0 ? matrix[i-1][j-1] : Integer.MAX_VALUE;
                int right = j < matrix[i].length-1 ? matrix[i-1][j+1] : Integer.MAX_VALUE;
                int min = Math.min(up, Math.min(left, right));
                matrix[i][j] = matrix[i][j] + min;
            }
        }

        int result = Integer.MAX_VALUE;
        for(int j = 0; j < matrix[matrix.length-1].length; j++){
            result = Math.min(result, matrix[matrix.length-1][j]);
        }

        return result;
    }
}
