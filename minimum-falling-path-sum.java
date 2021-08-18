//Time complexity: O(m*n), where m is rows and n is columns
//Space complexity: O(1), because the given array is manipulated
//running on leetcode: yes
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix==null || matrix.length==0)
        {
            return 0;
        }
        int m=matrix.length;
        int n= matrix[0].length;
        for (int i=1; i < m; i++)
        {
            for (int j=0; j<n; j++)
            {
                if (j==0)
                {
                    matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                }
                else if (j==n-1)
                {
                    matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                }
                else
                {
                    matrix[i][j] += Math.min(matrix[i-1][j], Math.min(matrix[i-1][j-1],matrix[i-1][j+1]));
                }
            }
        }
        //why do we need loop for accessing the answer element
        int min=Integer.MAX_VALUE;
        for (int i=0; i<n; i++)
        {
            min=Math.min(min, matrix[m-1][i]);
        }
        return min;
    }
}
