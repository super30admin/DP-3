package DP3;

//Time complexity : O(n^2) as we are calculating min for each element
//Space complexity: O(1)
class MinPathFallingSum {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return -1;
        int min = Integer.MAX_VALUE;
        for(int i=matrix.length-2; i>=0; i--){
            for(int j=0;j<matrix.length; j++){
                int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
                if(j == 0 && j == matrix.length-1){
                    b = matrix[i+1][j];
                } else if(j == 0){
                    b = matrix[i+1][j];
                    c = matrix[i+1][j+1];
                } else if(j == matrix.length -1){
                    a = matrix[i+1][j-1];
                    b = matrix[i+1][j];
                } else{
                    a = matrix[i+1][j-1];
                    b = matrix[i+1][j];
                    c = matrix[i+1][j+1];
                }
                matrix[i][j] = matrix[i][j] + Math.min(a, Math.min(b, c));
            }
        }
        for(int j=0; j< matrix.length; j++){
            min = Math.min(min, matrix[0][j]);
        }
        return min;
    }
}