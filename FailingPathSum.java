/**
 * Similar to Robbing House
 * We will start with n-2th row and start calculating the minimum at the each index[row, col]
 * We will propagate above similarly
 * 
 * Time Complexity: o(n^2): We are iterating across the matrix. Each Rown comparing with below and also calculating the minimum from column.[i+1][j-1], .[i+1][j+1], .[i+1][j]
 * Space Complexity : O(1) No Extra space. In place modification of Matrix.
 */
class FallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int m = matrix.length; 
        for(int i= m-2; i>=0; i--){
            for(int j=0; j<m; j++){
                if(j==0){
                    matrix[i][j] = matrix[i][j]+ Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }
                else if(j == m-1){
                    matrix[i][j] = matrix[i][j]+ Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }
                else{
                     matrix[i][j] = matrix[i][j]+ Math.min(matrix[i+1][j], Math.min(matrix[i+1][j-1],matrix[i+1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;

        for(int i=0; i<m; i++){
            min = Math.min(min, matrix[0][i]);
        }
        return min;
    }
}