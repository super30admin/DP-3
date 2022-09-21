//DP - same as Paint House 
//update the second last row based on the last and go on-- bottom to top

// take minimum of row1 as an answer
//SC- mutated the input matrix - O(1), if interviewer says dont mutate than it's O(n*n) = O(n^2) (matrix is n*n)
//TC: traverse through the n*n matrix = O(n*n) = O(n^2)

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        if(matrix == null || matrix.length ==0) return 0;
        
        //let's assume if matrix can be mutated
        int n = matrix.length;
        
        for(int i = n-2; i >= 0; i--)
        {
            for(int j =0; j < n; j++)
            {
                //boundary condition - j==0
                if(j ==0)
                {
                    matrix[i][j] = matrix[i][j]+ Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }
                
                //boundary condition - j==n-1
                else if(j == n-1)
                {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }
                else
                {
                    matrix[i][j] =  matrix[i][j] + Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j], matrix[i+1][j+1]));
                }
            }
        }
       
        int min = Integer.MAX_VALUE;
        for(int j =0; j< n; j++ )
        {
            min = Math.min(matrix[0][j], min);
        }
        return min;
    }
}
