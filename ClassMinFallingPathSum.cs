namespace LeetCodeSubmission.DP3;

public class ClassMinFallingPathSum
{
    public int MinFallingPathSum(int[][] matrix) {
        // mutate the matrix
        int rows = matrix.GetLength(0);
        int cols = matrix[0].GetLength(0);

        for (int r = rows - 2; r > -1; r--)
        {
            for (int c = 0; c < cols; c++)
            {
                if (c == 0)
                {
                    matrix[r][c] += Math.Min(matrix[r + 1][c], matrix[r + 1][c + 1]);
                }
                else if (c == cols-1)
                {
                    matrix[r][c] += Math.Min(matrix[r + 1][c], matrix[r + 1][c - 1]);
                }
                else
                {
                    matrix[r][c] += Math.Min(matrix[r + 1][c], Math.Min(matrix[r + 1][c + 1],matrix[r+1][c-1]));
                }
            }
        }
        
        // get the min from the first row
        int minValue = Int32.MaxValue;
        for (int c = 0; c < cols; c++)
        {
            minValue = Math.Min(minValue, matrix[0][c]);
        }

        return minValue;
    }
}