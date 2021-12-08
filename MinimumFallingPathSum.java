// Time Complexity : O(nm) n = no of row and m = no of columns
// Space Complexity : O(1) reusing input array

// Pattern3 where restriction is how you can travel in problem
public class MinimumFallingPathSum
{
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int n = matrix.length, m = matrix[0].length;
        
        for(int i = n-2 ; i >= 0 ; i--) // we start from second last row as reusing same i/p
        {
            for(int j = 0 ; j < m ; j ++)
            {
                // first col can go down and right
                if(j == 0)
                {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }
                // last col can go down and left
                else if (j == m-1)
                {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }
                // not compulsory that matrix will be n * 3 so all non corner columns can go
                // left, down and right
                else
                {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1], matrix[i+1][j+1]));
                }                                          
            }
        }

        int minSum = Integer.MAX_VALUE; 
        for(int j = 0 ; j < m ; j++)
        {
            minSum = Math.min(minSum, matrix[0][j]);
        }
        
        return minSum;
    }
}