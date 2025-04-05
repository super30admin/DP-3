public class Solution
{
    public int MinFallingPathSum(int[][] matrix)
    {
        if (matrix == null || matrix[0].Length == 0)
        {
            return Int32.MaxValue;
        }

        int n = matrix[0].Length;
        for (int i = n - 2; i >= 0; i--)
        {
            for (int j = 0; j < n; j++)
            {
                if (j == 0)
                {
                    matrix[i][j] += Math.Min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                }
                else if (j == n - 1)
                {
                    matrix[i][j] += Math.Min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                }
                else
                {
                    matrix[i][j] += Math.Min(matrix[i + 1][j - 1], Math.Min(matrix[i + 1][j], matrix[i + 1][j + 1]));
                }
            }
        }

        int min = Int32.MaxValue;

        for (int i = 0; i < n; i++)
        {
            min = Math.Min(min, matrix[0][i]);
        }
        return min;
    }
}