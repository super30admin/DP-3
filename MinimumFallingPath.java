// Time Complexity : O(N*M), N is rows length and M is columns length in the matrix.
// Space Complexity : O(1), 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// 1. We traverse the matrix row by row starting from the second row (i = 1).
// 2. For each cell matrix[i][j], we update it by adding the minimum of the valid adjacent cells from the previous row.
//    - If j is the first column, it can take values from j and j+1 of the previous row.
//    - If j is the last column, it can take values from j and j-1 of the previous row.
//    - Otherwise, it takes the minimum from j-1, j, and j+1 of the previous row.
// 3. After updating the matrix, the last row contains the minimum falling path sum for each column.
// 4. We find and return the minimum value from the last row.

public class MinimumFallingPath {
    public int minFallingPathSum(int[][] matrix) 
    {
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(j==0)
                {
                    int x = Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                    matrix[i][j] = matrix[i][j] + x;
                }
                else if(j== matrix[i].length-1)
                {
                    int y = Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                    matrix[i][j] = matrix[i][j] + y;
                }
                else
                {
                    int x = Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                    int y = Math.min(x,matrix[i-1][j-1]); 
                    matrix[i][j] = matrix[i][j] + y;
                }
            }
        }
        int op = Integer.MAX_VALUE;
        for(int j=0;j<matrix[0].length;j++)
        {
            op = Math.min(matrix[matrix.length-1][j],op);
        }
        return op;
    }
}
