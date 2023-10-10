// Time Complexity : O(M*N) where M is rows & N is columns
// Space Complexity :O(1) Not using any auxiliary space for calculations.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

public class MinimumFallingPathSum
{
    class Solution {
        public int minFallingPathSum(int[][] matrix)
        {
            int min = Integer.MAX_VALUE;
            for(int i = matrix.length-1; i>=0; i--)
            {
                for(int j = 0; j< matrix[0].length; j++)
                {
                    if(i != matrix.length-1)
                    {
                        if(j == 0)
                            matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                        else if(j == matrix[0].length-1)
                            matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1], matrix[i+1][j]);
                        else
                            matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j], matrix[i+1][j+1]));
                    }
                    if(i == 0)
                        min = Math.min(min, matrix[i][j] );
                }
            }

            return min;
        }
    }
}
