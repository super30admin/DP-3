// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {
    public int MinFallingPathSum(int[][] matrix) {
        int rows = matrix.Length, columns = matrix[0].Length;

        for(int i = 1; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(j==0)
                {
                    matrix[i][j] += Math.Min(matrix[i-1][j], matrix[i-1][j+1]);
                }

                else if(j == columns - 1)
                {
                    matrix[i][j] += Math.Min(matrix[i-1][j], matrix[i-1][j-1]);
                }

                else
                {
                    matrix[i][j] += Math.Min(Math.Min(matrix[i-1][j], matrix[i-1][j+1]), matrix[i-1][j-1]);
                }
            }
        }

        int result = matrix[rows-1][0];

        for(int j = 1; j < columns; j++)
        {
            result = Math.Min(result, matrix[rows-1][j]);
        }

        return result;
    }
}