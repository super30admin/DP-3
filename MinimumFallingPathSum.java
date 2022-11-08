package S30_Codes.DP_3;

// Time Complexity : O(i*j)
//Space Complexity : O(1)


class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {

        for(int i=1; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){

                int up = matrix[i-1][j];
                int diagonalLeft = j==0 ? Integer.MAX_VALUE : matrix[i-1][j-1];
                int diagonalRight = j == matrix.length-1 ? Integer.MAX_VALUE : matrix[i-1][j+1];

                matrix[i][j] += Math.min(up, Math.min(diagonalLeft, diagonalRight));
            }
        }

        int minPath = Integer.MAX_VALUE;
        for(int j=0; j<matrix.length; j++){
            minPath = Math.min(minPath, matrix[matrix.length-1][j]);
        }
        return minPath;
    }
}