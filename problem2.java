//Time Complexity = O(n*n)
//Space Complexity = O(1)


public int minFallingPathSum(int[][] matrix) {
    for(int i= matrix.length-2;i>=0;i--){
        for (int j =0;j<matrix.length;j++){
            if(j==0){
                matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j+1]);
            }
            else if(j==matrix.length-1){
                matrix[i][j] =matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j-1]);
            }
            else{
                matrix[i][j] =matrix[i][j] + Math.min(matrix[i+1][j+1],Math.min(matrix[i+1][j],matrix[i+1][j-1]));
            }
        }
        
    }
    int result = Integer.MAX_VALUE;
    for (int j = 0;j<matrix.length;j++){
        result = Math.min(result,matrix[0][j]);
    }
    return result;
}
}