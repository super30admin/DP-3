public class LeastFallingPathSum
	{
        // Time Complexity : O(n^2) 
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public int MinFallingPathSum(int[][] matrix)
        {
            if (matrix == null || matrix.Length == 0)
                return 0;

            int n = matrix.Length;
            int minSum = Int32.MaxValue;

            for(int i = n - 2; i >=0; i--)
            {
                for(int j = 0; j < n; j++)
                {
                    if (j == 0)
                    {
                        matrix[i][j] = matrix[i][j] + Math.Min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                    }
                    else if (j == n - 1)
                    {
                        matrix[i][j] = matrix[i][j] + Math.Min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                    }
                    else
                    {
                        matrix[i][j] = matrix[i][j] + Math.Min(matrix[i + 1][j - 1],Math.Min(matrix[i + 1][j], matrix[i + 1][j + 1]));
                    }
                }
            }
            for(int j = 0; j < n; j++)
            {
                minSum = Math.Min(minSum, matrix[0][j]);
            }

            return minSum;
        }
}
