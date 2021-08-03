/* Time Complexity : O(M * N), where M = rows and N = columns of the matrix
   Space Complexity : O(1)
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
   Method: DP without any extra storage. Taking minimum of the (before row, previous column), (before row,current column) and (before row,next column). When we are at the first column, we will have only two cases to find minimum - (before row,current column) and (before row,next column). When we are considering the last column, again only 2 cases - (before row, previous column), (before row,current column) 
   Finally, traverse the last row and all columns to find the minimum value and return it

*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n= matrix[0].length;
        for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j==0)
                {
                   matrix[i][j]+=Math.min(matrix[i-1][j],matrix[i-1][j+1]); 
                }
                else if(j==n-1)
                {
                    matrix[i][j]+=Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                }
                else
                {
                    matrix[i][j] += Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j],matrix[i-1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            min = Math.min(min,matrix[m-1][i]);
        }
        return min;
    }
}
