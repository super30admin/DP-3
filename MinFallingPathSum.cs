using System;
using System.Collections.Generic;
using System.Text;

namespace LeetCodeSuper30
{
    class MinFallingPathSumLC
    {
        //Time Complexity: O(m*n)
        //Space Complexity: O(1)
        public int MinFallingPathSum(int[][] matrix)
        {
            if (matrix == null || matrix.GetLength(0) == 0)
            {
                return 0;
            }
            int m = matrix.GetLength(0);
            int n = matrix.GetLength(1);
            for (int i = 1; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (j == 0)
                    {
                        matrix[i][j] += Math.Min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                    }
                    else if (j == n - 1)
                    {
                        matrix[i][j] += Math.Min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                    }
                    else
                    {
                        matrix[i][j] += Math.Min(matrix[i - 1][j], Math.Min(matrix[i - 1][j + 1], matrix[i - 1][j - 1]));
                    }
                }
            }
            int min = Int32.MaxValue;
            for (int i = 0; i < n; i++)
            {
                min = Math.Min(min, matrix[m - 1][i]);
            }
            return min;
        }
    }
}
