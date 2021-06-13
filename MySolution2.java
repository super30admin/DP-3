class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] matrix2 = new int[matrix.length][matrix[0].length];
        int fallingSum = 0;
        //Copying row one
        for (int i = 0; i<matrix[0].length; i++){
            matrix2[0][i] = matrix[0][i];


        }
        for (int i = 1; i<matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if(j==0){
                    matrix2[i][j] = Math.min(matrix[i][j] + matrix2[i-1][j], matrix[i][j] + matrix2[i-1][j+1] );

                }
                else if(j == matrix[0].length-1){
                    matrix2[i][j] = Math.min(matrix[i][j] + matrix2[i-1][j], matrix[i][j] + matrix2[i-1][j-1] );

                }
                else{
                    matrix2[i][j] = Math.min(matrix[i][j] + matrix2[i-1][j], Math.min(matrix[i][j] + matrix2[i-1][j+1] ,matrix[i][j] + matrix2[i-1][j-1]));

                }

            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i<matrix[0].length; i++){
            if (min > matrix2[matrix2[0].length-1][i]){
                min = matrix2[matrix2[0].length-1][i];
            }
        }

        return min;
    }
}