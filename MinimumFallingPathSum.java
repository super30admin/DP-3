// Time Complexity : O(n * 3) => O(n)
// Space Complexity : O(1)
// Method used : DP

class Solution {

    public int minFallingPathSum(int[][] matrix) {
        
        int rows = matrix.length, cols = matrix[0].length;
        int minimum = Integer.MAX_VALUE;

        for(int i = rows - 2; i >= 0; i--)
        {
            for(int j = 0; j < cols; j++)
            {
                if(j == 0) matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);

                else if(j == cols - 1) matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);

                else
                    matrix[i][j] += Math.min(matrix[i + 1][j - 1], Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]));
            }
        }

        for(int j = 0; j < cols; j++)
            minimum = Math.min(minimum, matrix[0][j]);
        
        return minimum;
    }
}