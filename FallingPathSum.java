//T.C = O(mn)
//S.C = O(1)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
       for(int i=m-2;i>=0;i--)
        {
            for(int j=0;j<n;j++)
            {
                if(j==0)
                {
                    matrix[i][j]= matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }
                else if(j==n-1)
                {
                    
                    matrix[i][j]= matrix[i][j] + Math.min(matrix[i+1][j-1],matrix[i+1][j]);                }
                
                else
                {
                    matrix[i][j]= matrix[i][j] + Math.min(matrix[i+1][j],Math.min (matrix[i+1][j+1],matrix[i+1][j-1]));
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++)
        {
            min = Math.min(min,matrix[0][i]);
        }
        
        return min;
        
    }
}