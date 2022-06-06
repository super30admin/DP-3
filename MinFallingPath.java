public class MinFallingPath {

    //TC is O(mn) where m is rows and n is column length
    //SC is constant
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        if(matrix.length == 1){
            for(int k=0;k<matrix[0].length;k++){
                min = Math.min(min, matrix[0][k]);
            }
        }
        for(int i=matrix.length-2; i>=0; i--){
            for(int j=0; j< matrix[0].length; j++){
                if(j>0 && j<matrix[0].length-1){
                    matrix[i][j] += Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1],matrix[i+1][j+1])); 
                } else if(j>0){
                    matrix[i][j] += Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }else{
                    matrix[i][j] += Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }
                if(i==0){
                    min = Math.min(min, matrix[i][j]);
                }
            }
        }
        return min;
    }
}