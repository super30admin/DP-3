// Time Complexity : O(mn), m -> no. of rows, n -> no. of cols
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for(int row = 1; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                // minVal = min(matrix[row+1][col-1], matrix[row+1][col], matrix[row+1][col+1])
                int minVal = matrix[row - 1][col]; 
                if(col > 0)
                    minVal = Math.min(minVal, matrix[row - 1][col - 1]);
                if(col + 1 < matrix[0].length)
                    minVal = Math.min(minVal, matrix[row - 1][col + 1]);
                matrix[row][col] += minVal;
            }
        }
        
        int minSum = Integer.MAX_VALUE;
        for(int sum : matrix[matrix.length - 1]) {
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }
}